package com.cmloopy.comic.view

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.HomeListComicAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.CategoryApi
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.ActivityCategoryBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idUser = intent.getIntExtra("idUser",-1)
        lifecycleScope.launch {
            val apiComicService = RetrofitClient.instance.create(ComicApi::class.java)
            val apiCateService = RetrofitClient.instance.create(CategoryApi::class.java)
            val category = withContext(Dispatchers.IO) {apiCateService.getAllCategory()}
            val comic = withContext(Dispatchers.IO) {apiComicService.getAllComicUpdate()}

            val nameCateee = category.map { it.nameCategory }
            binding.listSearchCate.layoutManager = LinearLayoutManager(this@CategoryActivity)
            binding.listSearchCate.adapter = HomeListComicAdapter(comic, idUser)

            val adapter = ArrayAdapter(this@CategoryActivity, android.R.layout.simple_spinner_item, nameCateee)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            binding.spinner.adapter = adapter
            binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
                override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                    val choose = category[p2].nameCategory
                    lifecycleScope.launch {
                        val apiComic = RetrofitClient.instance.create(ComicApi::class.java)
                        val comicc = withContext(Dispatchers.IO){apiComic.getComicByCategory(nameCategory = choose)}
                        binding.listSearchCate.adapter = HomeListComicAdapter(comicc,idUser)
                        binding.listSearchCate.run { adapter.notifyDataSetChanged() }
                    }
                }
                override fun onNothingSelected(p0: AdapterView<*>?) {}
            }
        }
        //Click
        btnCategoryOnClick()
    }

    private fun btnCategoryOnClick() {
        binding.btnBackHome2.setOnClickListener {
            onBackPressed()
        }
    }
}