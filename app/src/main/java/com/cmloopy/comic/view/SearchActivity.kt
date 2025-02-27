package com.cmloopy.comic.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmloopy.comic.R
import com.cmloopy.comic.databinding.ActivitySearchBinding

class SearchActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click
        btnSearchOnClick()
    }

    private fun btnSearchOnClick() {
        binding.btnBackHome.setOnClickListener {
            onBackPressed()
        }
    }
}