package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.databinding.FragmentTopFollowBinding
import Comic

class TopFollowFragment : Fragment() {
    private lateinit var _binding : FragmentTopFollowBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopFollowBinding.inflate(inflater,container,false)

        val list: ArrayList<Comic> = arrayListOf()

        binding.rclListTopFollow.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListTopFollow.adapter = TopAdapter(list,2)

        return binding.root
    }
}