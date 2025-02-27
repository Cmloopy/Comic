package com.cmloopy.comic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.cmloopy.comic.databinding.ActivityMainBinding
import androidx.viewpager2.widget.ViewPager2
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.MainViewPagerAdpater

private lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Thiết lập adapter cho viewpager
        val adapter = MainViewPagerAdpater(this)
        binding.vpgMain.adapter = adapter

        binding.vpgMain.isUserInputEnabled = false

        //Xử lý sự kiện khi click trên BottomNav
        binding.bottomNav.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.trangchu -> binding.vpgMain.setCurrentItem(0, true)
                R.id.bxh -> binding.vpgMain.setCurrentItem(1, true)
                R.id.canhan -> binding.vpgMain.setCurrentItem(2, true)
            }
            true
        }
    }
}