package com.example.playstationstore

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GameApi {
    @GET("api/games")
    fun getGames(): Call<List<Game>>

    @GET("api/game?id=")
    fun getSingleGame(@Query("id") id: Int): Call<Game>

    companion object {
        var BASE_URL = "https://www.freetogame.com/"

        fun create(): GameApi {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(GameApi::class.java)
        }
    }
}