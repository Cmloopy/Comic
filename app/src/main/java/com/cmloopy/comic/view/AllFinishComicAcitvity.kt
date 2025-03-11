package com.cmloopy.comic.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.cmloopy.comic.adapters.AllNewFullComicAdapter
import com.cmloopy.comic.databinding.ActivityAllFinishComicBinding
import Comic
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.cmloopy.comic.data.RetrofitClient
import com.cmloopy.comic.data.api.ComicApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class AllFinishComicAcitvity : AppCompatActivity() {
    private lateinit var binding: ActivityAllFinishComicBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllFinishComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val idUser = intent.getIntExtra("idUser", -1)

        lifecycleScope.launch {
            try {
                val apiService = RetrofitClient.instance.create(ComicApi::class.java)
                val allFinish = withContext(Dispatchers.IO) {apiService.getAllComicHT()}
                //Setup Recycleview
                initRecycle(allFinish, idUser)
            }
            catch (e: Exception){

            }
        }

        //Click btn tren activity
        btnAllFinishComicAc()
    }

    private fun btnAllFinishComicAc() {
        //Btn Back to Frg Home
        binding.btnBackFrgHome.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initRecycle(allFinish: ArrayList<Comic>, idUser:Int) {
        binding.rclListHT2.layoutManager = LinearLayoutManager(this)
        binding.rclListHT2.adapter = AllNewFullComicAdapter(allFinish, idUser)
    }
}