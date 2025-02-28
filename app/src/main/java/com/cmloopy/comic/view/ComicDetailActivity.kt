package com.cmloopy.comic.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.cmloopy.comic.databinding.ActivityComicDetailBinding

class ComicDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityComicDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityComicDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val idComic = intent.getIntExtra("idComic",-1)
        Log.e("error", "$idComic", )

        //Click
        btnComicDetailsOnClick()
    }

    private fun btnComicDetailsOnClick() {
        binding.btnBackPrevious.setOnClickListener {
            onBackPressed()
        }
    }
}