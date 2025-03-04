package com.cmloopy.comic.view

import Comic
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.AllNewFullComicAdapter
import com.cmloopy.comic.databinding.ActivityAllNewUpdateBinding

class AllNewUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllNewUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllNewUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup Recycleview
        initRecycle()

        //Click btn tren activity
        btnAllNewUpdateAc()
    }

    private fun btnAllNewUpdateAc() {
        //Btn Back to Frg Home
        binding.btnBackfFrgHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initRecycle() {
        val hotComic = ArrayList<Comic>()

        binding.rclListMCN2.layoutManager = LinearLayoutManager(this)
        binding.rclListMCN2.adapter = AllNewFullComicAdapter(hotComic)
    }
}