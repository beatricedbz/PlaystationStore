package com.example.playstationstore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.playstationstore.databinding.ActivityStoreGameDescriptionBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class StoreGameDescriptionActivity : AppCompatActivity() {
    lateinit var binding: ActivityStoreGameDescriptionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoreGameDescriptionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val gameApi = GameApi.create().getSingleGame(intent.getIntExtra("id", 0))
        gameApi.enqueue(object : Callback<Game> {
            override fun onResponse(call: Call<Game>, response: Response<Game>) {
                if (response.body() != null) {

                    Glide.with(applicationContext)
                        .load(response.body()!!.thumbnail)
                        .into(binding.ivGame)
                    binding.tvGenre.text = response.body()!!.genre
                    binding.tvTitle.text = response.body()!!.title
                    binding.tvPlatform.text = response.body()!!.platform
                    binding.tvDescription.text = response.body()!!.short_description
                }
            }

            override fun onFailure(call: Call<Game>, t: Throwable) {
                Toast.makeText(applicationContext, "CALL FAILED", Toast.LENGTH_LONG)
            }
        })
    }
}