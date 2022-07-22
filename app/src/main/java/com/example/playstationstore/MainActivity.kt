package com.example.playstationstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playstationstore.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var adapter: GameRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = GameRecyclerAdapter()
        binding.rvGameInfo.layoutManager = LinearLayoutManager(this)
        binding.rvGameInfo.adapter = adapter

        val gameApi = GameApi.create().getGames()
        gameApi.enqueue(object: Callback<List<Game>>{
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                if(response.body() != null){
                    Log.d("Zalyap", "${response.body()}")
                    adapter.fillGames(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "sdsd", Toast.LENGTH_LONG)
            }
        })


    }
}