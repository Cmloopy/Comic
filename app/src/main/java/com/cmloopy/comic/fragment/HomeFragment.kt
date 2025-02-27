package com.cmloopy.comic.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import com.cmloopy.comic.R
import com.cmloopy.comic.adapters.ImageSliderAdapter
import com.cmloopy.comic.adapters.HomeListComicAdapter
import com.cmloopy.comic.databinding.FragmentHomeBinding
import com.cmloopy.comic.models.Comic
import com.cmloopy.comic.view.AllFinishComicAcitvity
import com.cmloopy.comic.view.AllNewUpdateActivity
import com.cmloopy.comic.view.CategoryActivity
import com.cmloopy.comic.view.SearchActivity

class HomeFragment : Fragment() {
    private lateinit var _binding: FragmentHomeBinding
    private lateinit var handler: Handler
    private val binding get() = _binding
    private val hotComic = ArrayList<Comic>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        //Slider truyện đầu trang chủ
        initSlider()
        setUpSlider()
        //Callback cho slider để cuôn vô hạn
        callBackSlider()


        //List truyện mới cập nhật
        setUpNewestUpdateRecycle()

        //List truyen hoan thanh
        setUpFinishRecycle()

        //Click btn
        btnHomeFragmentOnClick()

        return binding.root
    }

    private fun btnHomeFragmentOnClick() {
        binding.btnXemthem1.setOnClickListener {
            val intent = Intent(requireContext(), AllNewUpdateActivity::class.java)
            //Them putExtra neu can gui data
            startActivity(intent)
        }
        binding.btnXemthem2.setOnClickListener {
            val intent = Intent(requireContext(), AllFinishComicAcitvity::class.java)
            //Them putExtra neu can gui data
            startActivity(intent)
        }
        binding.btnSrc.setOnClickListener {
            val intent = Intent(requireContext(), SearchActivity::class.java)
            //putExtra nếu muốn send Data
            startActivity(intent)
        }
        binding.btnCate.setOnClickListener {
            val intent = Intent(requireContext(), CategoryActivity::class.java)
            //putExtra nếu muốn đẩy Data
            startActivity(intent)
        }
    }

    private fun callBackSlider() {
        binding.vpgSlideimg.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable,3500)
            }
        })
    }

    private fun setUpNewestUpdateRecycle() {
        binding.rclListMCN.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListMCN.adapter = HomeListComicAdapter(hotComic)

    }

    private fun setUpFinishRecycle() {
        binding.rclListHT.layoutManager = LinearLayoutManager(requireContext())
        binding.rclListHT.adapter = HomeListComicAdapter(hotComic)
    }

    private val runnable = Runnable {
        binding.vpgSlideimg.currentItem += 1
    }

    private fun setUpSlider() {
        val trans = CompositePageTransformer()
        trans.addTransformer(MarginPageTransformer(50))
        binding.vpgSlideimg.setPageTransformer(trans)
    }

    private fun initSlider() {
        handler = Handler(Looper.myLooper()!!)

        hotComic.add(Comic(1,"Name Comic 1","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 2","Check", 1200, "test", "test", R.drawable.test2, 12, 12, 0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 3","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,1,  "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 4","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 5","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 6","Check", 1200, "test", "test", R.drawable.test2, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 7","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 8","Check", 1200, "test", "test", R.drawable.test2, 12, 12,1, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 9","Check", 1200, "test", "test", R.drawable.img_biamau, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        hotComic.add(Comic(1,"Name Comic 10","Check", 1200, "test", "test", R.drawable.test2, 12, 12,0, "Author 1", 1, 1, "Chapter 12"))
        val adapter = ImageSliderAdapter(hotComic, binding.vpgSlideimg)
        binding.vpgSlideimg.adapter = adapter
        binding.vpgSlideimg.offscreenPageLimit = 3
        binding.vpgSlideimg.clipToPadding = false
        binding.vpgSlideimg.clipChildren = false
        binding.vpgSlideimg.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()
        handler.postDelayed(runnable,3500)
    }
}