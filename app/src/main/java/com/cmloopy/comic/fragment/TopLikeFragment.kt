package com.cmloopy.comic.fragment

import Comic
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.databinding.FragmentTopLikeBinding

class TopLikeFragment : Fragment() {
    private lateinit var _binding : FragmentTopLikeBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopLikeBinding.inflate(inflater,container,false)

        val list: ArrayList<Comic> = arrayListOf()


        binding.rclListTopLike.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListTopLike.adapter = TopAdapter(list,1)

        return binding.root
    }
}