package com.cmloopy.comic.view

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.CategoryAdapter
import com.cmloopy.comic.adapters.ListChapAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.CategoryApi
import com.cmloopy.comic.data.api.ChapterApi
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.ActivityComicDetailBinding
import com.cmloopy.comic.models.Category
import com.google.firebase.storage.FirebaseStorage
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class ComicDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicDetailBinding
    private val storageReference = FirebaseStorage.getInstance().reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idComic = intent.getIntExtra("idComic",-1)
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
                binding.lv3cmn.adapter = ListChapAdapter(chapterEx)

                val layoutManager = LinearLayoutManager(this@ComicDetailActivity, LinearLayoutManager.HORIZONTAL, false)

                binding.rclCategory.layoutManager = layoutManager
                binding.rclCategory.adapter = CategoryAdapter(category)
            }
            catch (e: Exception){

            }
        }
        //Click
        btnComicDetailsOnClick()
    }

    private fun btnComicDetailsOnClick() {
        binding.btnBackPrevious.setOnClickListener {
            onBackPressed()
        }
        binding.btnListChapAll.setOnClickListener {

        }
        binding.btnDtdau.setOnClickListener {

        }
        binding.btnLikeee.setOnClickListener {

        }
        binding.btnFollow.setOnClickListener {

        }
    }
}