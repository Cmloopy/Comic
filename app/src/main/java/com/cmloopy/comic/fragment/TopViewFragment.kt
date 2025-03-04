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
import com.cmloopy.comic.databinding.FragmentTopViewBinding

class TopViewFragment : Fragment() {
    private lateinit var _binding : FragmentTopViewBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopViewBinding.inflate(inflater,container,false)

        val list: ArrayList<Comic> = arrayListOf()


        binding.rclListTopView.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListTopView.adapter = TopAdapter(list,0)

        return binding.root
    }
}