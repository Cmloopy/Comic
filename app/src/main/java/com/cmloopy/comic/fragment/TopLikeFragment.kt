package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.FragmentTopLikeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopLikeFragment : Fragment() {
    private lateinit var _binding : FragmentTopLikeBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopLikeBinding.inflate(inflater,container,false)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)
                val topLike = withContext(Dispatchers.IO) {apiService.getComicLike()}
                binding.rclListTopLike.layoutManager = LinearLayoutManager(requireContext())
                binding.rclListTopLike.adapter = TopAdapter(topLike,1)
            }
            catch (e:Exception){
                context?.let {
                    Toast.makeText(it, "Lỗi API: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
}