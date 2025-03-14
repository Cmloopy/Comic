package com.cmloopy.comic.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.UserApi
import com.cmloopy.comic.databinding.ActivityLoginBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.create

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.materialButtonLG.setOnClickListener {
            val usn = binding.txtUsn.text.toString()
            val pass = binding.edtPass.text.toString()
            checkLogin(usn, pass)
        }
    }
    fun checkLogin(username: String, pass: String){
        lifecycleScope.launch {
            try {
                val apiUserService = RetrofitClient.instance.create(UserApi::class.java)
                val user = withContext(Dispatchers.IO){apiUserService.checkLogin(username = username, pass = pass)}
                if (user.size!=0){
                    val intent= Intent(this@LoginActivity, MainActivity::class.java)
                    intent.putExtra("idUser", user[0].idUser)
                    startActivity(intent)
                }
                else
                {
                    NotificationDiaglog(this@LoginActivity)
                }
            }
            catch (e:Exception){
                println(e)
            }
        }
    }
    fun NotificationDiaglog(context: Context){
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Opps!!")
            .setMessage("Thông tin tài khoản hoặc mật khẩu không chính xác!")
            .setPositiveButton("OK") { dialog, _ ->
                dialog.dismiss()
            }
        val dialog = builder.create()
        dialog.show()
    }
}