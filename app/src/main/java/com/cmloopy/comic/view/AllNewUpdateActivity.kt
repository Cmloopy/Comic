package com.cmloopy.comic.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.AllNewUpdateComicAdapter
import com.cmloopy.comic.databinding.ActivityAllNewUpdateBinding
import com.cmloopy.comic.models.Comic

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
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, "Author1", 1, 1, "Chapter12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.test2, 12, 12, "Author1", 1, 1, "Chapter12"))

        binding.rclListMCN2.layoutManager = LinearLayoutManager(this)
        binding.rclListMCN2.adapter = AllNewUpdateComicAdapter(hotComic)
    }
}