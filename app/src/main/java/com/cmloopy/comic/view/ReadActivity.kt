package com.cmloopy.comic.view

import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.DialogAllChapAdapter
import com.cmloopy.comic.adapters.ReadAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ChapterApi
import com.cmloopy.comic.databinding.ActivityReadBinding
import com.cmloopy.comic.models.Chapter
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding
    private val StorageRef = Firebase.storage.reference
    private var idUser = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Lay id chapter + comic cua chap
        val idComic = intent.getIntExtra("idComic",-1)
        val idChapter = intent.getIntExtra("idChapter",-1)
        idUser = intent.getIntExtra("idUser", -1)
        lifecycleScope.launch {
            val apiChapterService = RetrofitClient.instance.create(ChapterApi::class.java)

            val all_chapter = withContext(Dispatchers.IO) {apiChapterService.getChapterByIdComic(idComic = idComic)}
            val info_chapter = withContext(Dispatchers.IO) {apiChapterService.getChapterById(idChapter = idChapter)}
            val list_id_chap = all_chapter.map { it.idChapter }
            val posit = list_id_chap.indexOf(idChapter)

            binding.btnAllChap.text = info_chapter[0].nameChapter
            //Lay toan bo anh gan vao adapter
            val storageRef = StorageRef.child(info_chapter[0].urlChapter)
            val fileNames = mutableListOf<String>()
            storageRef.listAll()
                .addOnSuccessListener { listResult ->
                    listResult.items.forEach { item ->
                        fileNames.add(info_chapter[0].urlChapter + "/" + item.name)
                    }
                    binding.docThoi.layoutManager = LinearLayoutManager(this@ReadActivity)
                    binding.docThoi.adapter = ReadAdapter(fileNames)

                }
                .addOnFailureListener { exception -> }
            binding.btnPreChap.setOnClickListener {
                if (posit < list_id_chap.size-1){
                    val intent = Intent(this@ReadActivity,ReadActivity::class.java)
                    intent.putExtra("idComic",idComic)
                    intent.putExtra("idUser",idUser)
                    intent.putExtra("idChapter",list_id_chap[posit+1])
                    startActivity(intent)
                } else {
                    //Toast het chap cu
                }
            }

            binding.btnAllChap.setOnClickListener {
                ShowDialogAllChap(idComic, all_chapter, posit, info_chapter[0])
            }

            binding.btnNextChap.setOnClickListener {
                if(posit > 0){
                    val intent = Intent(this@ReadActivity,ReadActivity::class.java)
                    intent.putExtra("idComic",idComic)
                    intent.putExtra("idUser",idUser)
                    intent.putExtra("idChapter",list_id_chap[posit-1])
                    startActivity(intent)
                } else{
                    //Toast het chap moi
                }
            }
            binding.btnLike.setOnClickListener {
                if(idUser < 0){
                    Login()
                }
                else{
                    //Xu ly like api
                }
            }

        }
        binding.btnBacktohome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("idUser",idUser)
            startActivity(intent)
        }
    }
    fun Login(){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
    fun ShowDialogAllChap(idCm: Int, list: ArrayList<Chapter>, posit: Int, i4: Chapter){
        val dialog = Dialog(this)
        val view = LayoutInflater.from(this).inflate(R.layout.custom_dialog_all_chapter, null)
        dialog.setContentView(view)

        val listGridAllChap = view.findViewById<RecyclerView>(R.id.rcl_choose_chap)
        val gridLayoutManager = GridLayoutManager(this, 3)
        listGridAllChap.layoutManager = gridLayoutManager
        listGridAllChap.adapter = DialogAllChapAdapter(list, posit) {selectedItem ->
            val intent = Intent(this, ReadActivity::class.java)
            intent.putExtra("idComic",idCm)
            intent.putExtra("idUser",idUser)
            intent.putExtra("idChapter",selectedItem.idChapter)
            startActivity(intent)
        }
        listGridAllChap.post {
            (listGridAllChap.layoutManager as GridLayoutManager).scrollToPositionWithOffset(posit, 0)
        }
        dialog.show()
    }
}