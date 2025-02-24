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

        // Điều khiển BottomNavigationView khi vuốt ViewPager2
        binding.vpgMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNav.selectedItemId = R.id.trangchu
                    1 -> binding.bottomNav.selectedItemId = R.id.bxh
                    2 -> binding.bottomNav.selectedItemId = R.id.canhan
                }
            }
        })

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