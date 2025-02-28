package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.databinding.FragmentTopLikeBinding
import com.cmloopy.comic.models.Comic

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
        list.add(Comic(1,"Name Comic 2","Check", 1234, "test", "test", R.drawable.img_biamau, 1230, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 1","Check", 1232, "test", "test", R.drawable.test2, 1212, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 3","Check", 1221, "test", "test", R.drawable.img_biamau, 1102, 12,1,  "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 6","Check", 1212, "test", "test", R.drawable.test2, 1003, 12,1, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 5","Check", 1190, "test", "test", R.drawable.img_biamau, 1000, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 4","Check", 1180, "test", "test", R.drawable.test2, 931, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 7","Check", 1100, "test", "test", R.drawable.img_biamau, 912, 12,0, "Author 1", 1, 1, "Chapter 12"))
        list.add(Comic(1,"Name Comic 8","Check", 1000, "test", "test", R.drawable.test2, 900, 12,1, "Author 1", 1, 1, "Chapter 12"))

        binding.rclListTopLike.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListTopLike.adapter = TopAdapter(list,1)

        return binding.root
    }
}