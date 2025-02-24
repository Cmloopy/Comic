package com.cmloopy.comic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cmloopy.comic.fragment.HomeFragment
import com.cmloopy.comic.fragment.PersonFragment
import com.cmloopy.comic.fragment.RankFragment

class MainViewPagerAdpater(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment()
            1 -> RankFragment()
            2 -> PersonFragment()
            else -> HomeFragment()
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}