package com.cmloopy.comic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cmloopy.comic.adapters.ViewPagerTopAdapter
import com.cmloopy.comic.databinding.FragmentRankBinding
import com.google.android.material.tabs.*

class RankFragment : Fragment() {
    private lateinit var _binding: FragmentRankBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRankBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ViewPagerTopAdapter(this)
        binding.vpgBxh.adapter = adapter

        binding.vpgBxh.isUserInputEnabled = true

        TabLayoutMediator(binding.selectBxh, binding.vpgBxh) { tab, position ->
            tab.text = when(position){
                0 -> "Top lượt xem"
                1 -> "Top lượt thích"
                2 -> "Top theo dõi"
                else -> ""
            }
        }.attach()
    }
}