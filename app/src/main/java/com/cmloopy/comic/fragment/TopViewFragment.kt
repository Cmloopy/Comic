package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.databinding.FragmentTopViewBinding
import com.cmloopy.comic.models.Comic

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
        list.add(Comic(1,"Name Comic 1","Check", 1234, "test", "test", R.drawable.img_biamau, 12, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 2","Check", 1232, "test", "test", R.drawable.test2, 12, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 3","Check", 1221, "test", "test", R.drawable.img_biamau, 12, 12,1,  "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 4","Check", 1212, "test", "test", R.drawable.test2, 12, 12,1, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 5","Check", 1190, "test", "test", R.drawable.img_biamau, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 6","Check", 1180, "test", "test", R.drawable.test2, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 7","Check", 1100, "test", "test", R.drawable.img_biamau, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 8","Check", 1000, "test", "test", R.drawable.test2, 12, 12,1, "Author 1", 1, 1, "Chapter 12"))

        binding.rclListTopView.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListTopView.adapter = TopAdapter(list,0)

        return binding.root
    }
}