package com.cmloopy.comic.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.ReadAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ChapterApi
import com.cmloopy.comic.databinding.ActivityReadBinding
import com.google.firebase.Firebase
import com.google.firebase.storage.storage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ReadActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadBinding
    private val StorageRef = Firebase.storage.reference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Lay id chapter + comic cua chap
        val idComic = intent.getIntExtra("idComic",-1)
        val idChapter = intent.getIntExtra("idChapter",-1)
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
                    intent.putExtra("idChapter",list_id_chap[posit+1])
                    startActivity(intent)
                } else {

                }
            }
            binding.btnNextChap.setOnClickListener {
                if(posit > 0){
                    val intent = Intent(this@ReadActivity,ReadActivity::class.java)
                    intent.putExtra("idComic",idComic)
                    intent.putExtra("idChapter",list_id_chap[posit-1])
                    startActivity(intent)
                } else{

                }
            }

        }
        binding.btnBacktohome.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}