package com.cmloopy.comic.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.cmloopy.comic.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLoginGoogle.setOnClickListener {
            GoogleLogin()
        }
        binding.btnLoginFacebook.setOnClickListener {
            FaceBookLogin()
        }
        binding.btnLoginLine.setOnClickListener {
            Toast.makeText(this,"Chức năng đang cập nhật!", Toast.LENGTH_SHORT).show()
        }
        binding.btnLoginWhatsapp.setOnClickListener {
            Toast.makeText(this,"Chức năng đang cập nhật!", Toast.LENGTH_SHORT).show()
        }
    }
    //Cấu hình Google Login
    private fun GoogleLogin(){

    }
    //Cấu hình Facebook Login
    private fun FaceBookLogin(){

    }
}