package com.cmloopy.comic.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmloopy.comic.databinding.FragmentPersonBinding

class PersonFragment : Fragment() {
    private lateinit var _binding: FragmentPersonBinding
    private val binding get() = _binding
    private var idUser = -1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPersonBinding.inflate(inflater, container, false)
        arguments?.let {
            idUser = it.getInt("idUser", -1)
        }

        return binding.root
    }
    fun newInstance(idUser: Int): PersonFragment {
        val fragment = PersonFragment()
        val args = Bundle()
        args.putInt("idUser", idUser)
        fragment.arguments = args
        return fragment
    }
}