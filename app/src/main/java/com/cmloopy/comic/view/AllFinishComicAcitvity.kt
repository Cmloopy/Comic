package com.cmloopy.comic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.AllNewFullComicAdapter
import com.cmloopy.comic.databinding.ActivityAllFinishComicBinding
import Comic

class AllFinishComicAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityAllFinishComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllFinishComicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Setup Recycleview
        initRecycle()

        //Click btn tren activity
        btnAllFinishComicAc()
    }

    private fun btnAllFinishComicAc() {
        //Btn Back to Frg Home
        binding.btnBackFrgHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initRecycle() {
        val hotComic = ArrayList<Comic>()

        binding.rclListHT2.layoutManager = LinearLayoutManager(this)
        binding.rclListHT2.adapter = AllNewFullComicAdapter(hotComic)
    }
}