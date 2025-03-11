package com.cmloopy.comic.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.CategoryAdapter
import com.cmloopy.comic.adapters.ListChapAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.CategoryApi
import com.cmloopy.comic.data.api.ChapterApi
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.ActivityComicDetailBinding
import com.cmloopy.comic.models.Chapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.button.MaterialButton
import com.google.android.material.textview.MaterialTextView
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ComicDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicDetailBinding
    private val storageReference = FirebaseStorage.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Nhận id comic từ intent
        val idComic = intent.getIntExtra("idComic",-1)
        val idUser = intent.getIntExtra("idUser",-1)

        //Setup Data cho Activity từ API
        lifecycleScope.launch {
            try {
                val apiComicService = RetrofitClient.instance.create(ComicApi::class.java)
                val apiCateService = RetrofitClient.instance.create(CategoryApi::class.java)
                val apiChapterService = RetrofitClient.instance.create(ChapterApi::class.java)
                val comic = withContext(Dispatchers.IO){apiComicService.getComicById(idComic = idComic)}
                val category = withContext(Dispatchers.IO){apiCateService.getAllCategoryByComicId(idComic = idComic)}
                val chapter = withContext(Dispatchers.IO) {apiChapterService.getChapterByIdComic(idComic = idComic)}
                val chapterEx = ArrayList(chapter.subList(0,5))
                val imageRef = storageReference.child(comic[0].imageUrl)

                val list_link_chap = ArrayList(chapter.map { it.urlChapter })
                val list_id_chap = ArrayList(chapter.map { it.idChapter })
                imageRef.downloadUrl.addOnSuccessListener { uri ->
                    Picasso.get()
                        .load(uri)
                        .placeholder(R.drawable.loading)
                        .error(R.drawable.warning)
                        .into(binding.imgAnhbia)
                }.addOnFailureListener { exception ->
                    // Xử lý khi có lỗi xảy ra trong quá trình tải ảnh
                }
                binding.txtNamecomic.text = comic[0].nameComic
                binding.txtLuotLike.text = comic[0].likes.toString()
                binding.txtDoHot.text = comic[0].view.toString()
                binding.txtLuotTD.text = "734"
                binding.txtNd.text = comic[0].content
                binding.txtSlChap.text = "Chapter (${comic[0].sc})"

                binding.lv3cmn.layoutManager = LinearLayoutManager(this@ComicDetailActivity)
                binding.lv3cmn.addItemDecoration(DividerItemDecoration(this@ComicDetailActivity, DividerItemDecoration.VERTICAL))
                binding.lv3cmn.adapter = ListChapAdapter(idComic,chapterEx, idUser)

                val layoutManager = LinearLayoutManager(this@ComicDetailActivity, LinearLayoutManager.HORIZONTAL, false)

                binding.rclCategory.layoutManager = layoutManager
                binding.rclCategory.adapter = CategoryAdapter(category)

                //Click xem all list
                binding.btnListChapAll.setOnClickListener {
                    setUpBottomSheetListChap(idComic, comic[0].sc, chapter, idUser)
                }
                //Doc tu dau
                binding.btnDtdau.setOnClickListener {
                    val intent = Intent(this@ComicDetailActivity, ReadActivity::class.java)
                    intent.putExtra("idUser",idUser)
                    intent.putExtra("idComic", idComic)
                    intent.putExtra("idChapter",list_id_chap[list_id_chap.size-1])
                    startActivity(intent)
                }
            }
            catch (e: Exception){
                println(e)
            }
        }

        //Click
        binding.btnBackPrevious.setOnClickListener {
            onBackPressed()
        }
        binding.btnLikeee.setOnClickListener {

        }
        binding.btnFollow.setOnClickListener {

        }
    }

    private fun setUpBottomSheetListChap(idComic: Int, slChap : Int, chapter: ArrayList<Chapter>, idUser: Int) {
        val dialog = BottomSheetDialog(this)
        val view = layoutInflater.inflate(R.layout.bottom_sheet_list_chap, null)
        //Setup recycleView
        val listAll = view.findViewById<RecyclerView>(R.id.rcl_listFullChap)
        listAll.layoutManager = LinearLayoutManager(this)
        listAll.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        listAll.adapter = ListChapAdapter(idComic,chapter, idUser)
        val txtSL = view.findViewById<MaterialTextView>(R.id.txt_capnhat)
        txtSL.text = "Cập nhật đến chap ${slChap}"
        //Setup btn
        val btnOld = view.findViewById<MaterialButton>(R.id.btn_oldest)
        val btnNew = view.findViewById<MaterialButton>(R.id.btn_newest)
        val chapterNw = chapter
        btnOld.setOnClickListener {
            val chapterRv = ArrayList(chapter.reversed())
            listAll.adapter = ListChapAdapter(idComic,chapterRv, idUser)
            listAll.run { adapter?.notifyDataSetChanged() }
            btnOld.setTextColor(resources.getColor(R.color.btn))
            btnNew.setTextColor(resources.getColor(R.color.text2))
        }
        btnNew.setOnClickListener {
            listAll.adapter = ListChapAdapter(idComic,chapterNw, idUser)
            listAll.run { adapter?.notifyDataSetChanged() }
            btnNew.setTextColor(resources.getColor(R.color.btn))
            btnOld.setTextColor(resources.getColor(R.color.text2))
        }

        view.post {
            val bottomSheet = dialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            bottomSheet?.let {
                val behavior = BottomSheetBehavior.from(it)
                behavior.peekHeight = 600 // Đặt chiều cao cố định
                behavior.state = BottomSheetBehavior.STATE_EXPANDED // Giữ trạng thái mở rộng
                behavior.isDraggable = false // Không cho phép kéo lên/xuống

                it.setBackgroundColor(Color.TRANSPARENT)
            }

        }

        //Tắt sheet khi bấm ra ngoài
        dialog.setCancelable(true)
        dialog.setContentView(view)
        dialog.show()
    }
}