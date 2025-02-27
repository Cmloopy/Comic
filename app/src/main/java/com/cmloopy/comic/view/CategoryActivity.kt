package com.cmloopy.comic.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cmloopy.comic.R
import com.cmloopy.comic.databinding.ActivityCategoryBinding

class CategoryActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCategoryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Click
        btnCategoryOnClick()
    }

    private fun btnCategoryOnClick() {
        binding.btnBackHome2.setOnClickListener {
            onBackPressed()
        }
    }
}