package com.cmloopy.comic.fragment

import Comic
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.FragmentTopViewBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class TopViewFragment : Fragment() {
    private lateinit var _binding : FragmentTopViewBinding
    private val binding get() = _binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopViewBinding.inflate(inflater,container,false)

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)
                val topView = withContext(Dispatchers.IO) {apiService.getComicHot()}
                binding.rclListTopView.layoutManager = LinearLayoutManager(requireContext())
                binding.rclListTopView.adapter = TopAdapter(topView,0)
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