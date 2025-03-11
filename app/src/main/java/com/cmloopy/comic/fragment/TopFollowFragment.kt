package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.TopAdapter
import com.cmloopy.comic.databinding.FragmentTopFollowBinding
import Comic
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class TopFollowFragment : Fragment() {
    private lateinit var _binding : FragmentTopFollowBinding
    private val binding get() = _binding
    private var idUser = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTopFollowBinding.inflate(inflater,container,false)
        arguments?.let {
            idUser = it.getInt("idUser", -1)
        }

        viewLifecycleOwner.lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)
                val topView = withContext(Dispatchers.IO) {apiService.getComicHot()}
                binding.rclListTopFollow.layoutManager = LinearLayoutManager(requireContext())
                binding.rclListTopFollow.adapter = TopAdapter(topView, idUser,2)
            }
            catch (e:Exception){
                context?.let {
                    Toast.makeText(it, "Lỗi API: ${e.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }

        return binding.root
    }
    //Object nhan data tu activity, fragment cha
    fun newInstance(idUser: Int): TopFollowFragment {
        val fragment = TopFollowFragment()
        val args = Bundle()
        args.putInt("idUser", idUser)
        fragment.arguments = args
        return fragment
    }
}