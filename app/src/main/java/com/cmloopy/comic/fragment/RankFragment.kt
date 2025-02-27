package com.cmloopy.comic.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.cmloopy.comic.databinding.FragmentRankBinding

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
}