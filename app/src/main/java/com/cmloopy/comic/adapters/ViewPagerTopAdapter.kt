package com.cmloopy.comic.adapters

import android.app.Activity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.cmloopy.comic.fragment.TopFollowFragment
import com.cmloopy.comic.fragment.TopLikeFragment
import com.cmloopy.comic.fragment.TopViewFragment

class ViewPagerTopAdapter(fragment: Fragment,idUser: Int): FragmentStateAdapter(fragment) {
    private val fragments = listOf(
        TopViewFragment().newInstance(idUser),
        TopLikeFragment().newInstance(idUser),
        TopFollowFragment().newInstance(idUser)
    )
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

}