package com.cmloopy.comic.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cmloopy.comic.fragment.HomeFragment
import com.cmloopy.comic.fragment.PersonFragment
import com.cmloopy.comic.fragment.RankFragment

class MainViewPagerAdpater(activity: FragmentActivity, private val idUser: Int) : FragmentStateAdapter(activity) {
    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeFragment().newInstance(idUser)
            1 -> RankFragment().newInstance(idUser)
            2 -> PersonFragment().newInstance(idUser)
            else -> HomeFragment().newInstance(idUser)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }
}