package com.cmloopy.comic.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.cmloopy.comic.databinding.FragmentPersonBinding
import com.cmloopy.comic.view.LoginActivity

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
        if(idUser < 0){
            binding.txtNameUser.setOnClickListener { Login() }
            binding.btnDd.setOnClickListener { Login() }
            binding.btnMoreif.setOnClickListener { Login() }
        }

        return binding.root
    }
    //Object nhan data tu activity, fragment cha
    fun newInstance(idUser: Int): PersonFragment {
        val fragment = PersonFragment()
        val args = Bundle()
        args.putInt("idUser", idUser)
        fragment.arguments = args
        return fragment
    }
    fun Login(){
        val intent = Intent(requireContext(), LoginActivity::class.java)
        startActivity(intent)
    }
}