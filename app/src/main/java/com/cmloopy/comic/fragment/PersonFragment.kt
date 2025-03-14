package com.cmloopy.comic.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.cmloopy.comic.MoreIfActivity
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.UserApi
import com.cmloopy.comic.databinding.FragmentPersonBinding
import com.cmloopy.comic.view.LoginActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

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
        else{
            viewLifecycleOwner.lifecycleScope.launch {
                try {
                    val apiUserService = RetrofitClient.instance.create(UserApi::class.java)
                    val user = withContext(Dispatchers.IO) {apiUserService.getUserById(idUser = idUser)}
                    binding.txtNameUser.text = user[0].nameUser
                    binding.txtCount.text = user[0].count.toString()
                    binding.txtChuoi.text = idUser.toString()

                }
                catch (e: Exception){
                    Toast.makeText(requireContext(),"${e}",Toast.LENGTH_SHORT).show()
                }
            }
            binding.btnMoreif.setOnClickListener {
                val intent = Intent(requireContext(),MoreIfActivity::class.java)
                intent.putExtra("idUser", idUser)
                startActivity(intent)
            }
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