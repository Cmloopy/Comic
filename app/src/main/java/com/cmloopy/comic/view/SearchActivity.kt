package com.cmloopy.comic.view

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.HomeListComicAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.ActivitySearchBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SearchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idUser = intent.getIntExtra("idUser",-1)
        lifecycleScope.launch {
            try {
                val apiComic = RetrofitClient.instance.create(ComicApi::class.java)
                val comic = withContext(Dispatchers.IO) {apiComic.getAllComicUpdate()}

                binding.listSearch.layoutManager = LinearLayoutManager(this@SearchActivity)
                binding.listSearch.adapter = HomeListComicAdapter(comic, idUser)
                val nameComic = comic.map { it.nameComic }

                val adapter = ArrayAdapter(this@SearchActivity, android.R.layout.simple_dropdown_item_1line, nameComic)
                binding.searchInput.setAdapter(adapter)

                binding.searchInput.setOnItemClickListener { parent, view, position, id ->
                    val selectedName = parent.getItemAtPosition(position).toString()
                    val arrComic = ArrayList(comic.filter { it.nameComic == selectedName })
                    binding.listSearch.adapter = HomeListComicAdapter(arrComic, idUser)
                    binding.listSearch.run { run { adapter.notifyDataSetChanged() } }
                }
            }
            catch (e: Exception){
                println(e)
            }
        }


        //Click
        btnSearchOnClick()
    }

    private fun btnSearchOnClick() {
        binding.btnBackHome.setOnClickListener {
            onBackPressed()
        }
    }
}