package com.cmloopy.comic.view

import Comic
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.AllNewFullComicAdapter
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import com.cmloopy.comic.databinding.ActivityAllNewUpdateBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllNewUpdateActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllNewUpdateBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllNewUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idUser = intent.getIntExtra("idUser",-1)
        lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)
                val allNew = withContext(Dispatchers.IO) {apiService.getAllComicUpdate()}
                //Setup Recycleview
                initRecycle(allNew, idUser)
            }
            catch (e: Exception){
                println(e)
            }
        }

        //Click btn tren activity
        btnAllNewUpdateAc()
    }

    private fun btnAllNewUpdateAc() {
        //Btn Back to Frg Home
        binding.btnBackfFrgHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initRecycle(allNew: ArrayList<Comic>, idUser: Int) {
        binding.rclListMCN2.layoutManager = LinearLayoutManager(this)
        binding.rclListMCN2.adapter = AllNewFullComicAdapter(allNew, idUser)
    }
}