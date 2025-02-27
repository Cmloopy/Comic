package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

        return binding.root
    }
}