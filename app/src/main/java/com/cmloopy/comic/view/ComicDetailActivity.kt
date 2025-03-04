package com.cmloopy.comic.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.CategoryAdapter
import com.cmloopy.comic.databinding.ActivityComicDetailBinding
import com.cmloopy.comic.models.Category

class ComicDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idComic = intent.getIntExtra("idComic",-1)
        Log.e("error", "$idComic", )

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        binding.rclCategory.layoutManager = layoutManager

        val item: ArrayList<Category> = arrayListOf()
        item.add(Category(1,"Han"))
        item.add(Category(2,"Trung"))
        item.add(Category(3,"Nhat"))
        item.add(Category(4,"Viet"))
        item.add(Category(5,"My"))

        binding.rclCategory.adapter = CategoryAdapter(item)
        //Click
        btnComicDetailsOnClick()
    }

    private fun btnComicDetailsOnClick() {
        binding.btnBackPrevious.setOnClickListener {
            onBackPressed()
        }
    }
}