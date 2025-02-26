package com.cmloopy.comic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.AllNewFullComicAdapter
import com.cmloopy.comic.databinding.ActivityAllFinishComicBinding
import com.cmloopy.comic.models.Comic

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
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12, 1,"Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12, 1,"Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author1", 1, 1, "Chapter12"))

        binding.rclListHT2.layoutManager = LinearLayoutManager(this)
        binding.rclListHT2.adapter = AllNewFullComicAdapter(hotComic)
    }
}