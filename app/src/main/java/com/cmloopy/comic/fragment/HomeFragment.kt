package com.cmloopy.comic.fragment

import Comic
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cmloopy.comic.adapters.ImageSliderAdapter
import com.cmloopy.comic.adapters.HomeListComicAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.FragmentHomeBinding
import com.cmloopy.comic.view.AllFinishComicAcitvity
import com.cmloopy.comic.view.AllNewUpdateActivity
import com.cmloopy.comic.view.CategoryActivity
import com.cmloopy.comic.view.SearchActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private lateinit var handler: Handler
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        // Khởi tạo Handler ngay trong onCreateView()
        handler = Handler(Looper.getMainLooper())

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)

                // Gọi API và nhận dữ liệu
                val hotComic = withContext(Dispatchers.IO) { apiService.getComicHot() }
                val fullComic = withContext(Dispatchers.IO) { apiService.getComicHT() }
                val newComic = withContext(Dispatchers.IO) { apiService.getComicUpdate() }

                // Cập nhật UI mà không cần runOnUiThread
                initSlider(hotComic)
                setUpSlider()
                callBackSlider()
                setUpNewestUpdateRecycle(newComic)
                setUpFinishRecycle(fullComic)

            } catch (e: Exception) {
                context?.let {
                    Toast.makeText(it, "Lỗi API: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        // Xử lý sự kiện click button
        btnHomeFragmentOnClick()

        return binding.root
    }

    private fun btnHomeFragmentOnClick() {
        binding.btnXemthem1.setOnClickListener {
            val intent = Intent(requireContext(), AllNewUpdateActivity::class.java)
            startActivity(intent)
        }
        binding.btnXemthem2.setOnClickListener {
            val intent = Intent(requireContext(), AllFinishComicAcitvity::class.java)
            startActivity(intent)
        }
        binding.btnSrc.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            startActivity(intent)
        }
        binding.btnCate.setOnClickListener {
            val intent = Intent(requireContext(), CategoryActivity::class.java)
            startActivity(intent)
        }
    }

    private fun callBackSlider() {
        binding.vpgSlideimg.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (::handler.isInitialized) {
                    handler.removeCallbacks(runnable)
                    handler.postDelayed(runnable, 3500)
                }
            }
        })
    }

    private fun setUpNewestUpdateRecycle(new: ArrayList<Comic>) {
        binding.rclListMCN.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListMCN.adapter = HomeListComicAdapter(new)
    }

    private fun setUpFinishRecycle(full: ArrayList<Comic>) {
        binding.rclListHT.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListHT.adapter = HomeListComicAdapter(full)
    }

    private val runnable = Runnable {
        binding.vpgSlideimg.currentItem += 1
    }

    private fun setUpSlider() {
        val trans = CompositePageTransformer()
        trans.addTransformer(MarginPageTransformer(50))
        binding.vpgSlideimg.setPageTransformer(trans)
    }

    private fun initSlider(hotComic: ArrayList<Comic>) {
        val adapter = ImageSliderAdapter(hotComic, binding.vpgSlideimg)
        binding.vpgSlideimg.adapter = adapter
        binding.vpgSlideimg.offscreenPageLimit = 3
        binding.vpgSlideimg.clipToPadding = false
        binding.vpgSlideimg.clipChildren = false
        binding.vpgSlideimg.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    override fun onPause() {
        super.onPause()
        if (::handler.isInitialized) {
            handler.removeCallbacks(runnable)
        }
    }

    override fun onResume() {
        super.onResume()
        if (::handler.isInitialized) {
            handler.postDelayed(runnable, 3500)
        }
    }
}
