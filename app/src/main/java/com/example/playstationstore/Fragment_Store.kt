package com.example.playstationstore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.playstationstore.databinding.FragmentStoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Fragment_Store : Fragment() {
    private var _binding: FragmentStoreBinding? = null
    lateinit var adapter: GameRecyclerAdapter
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStoreBinding.inflate(inflater, container, false)
        adapter = GameRecyclerAdapter()
        binding.rvGameInfo.layoutManager = LinearLayoutManager(context)
        binding.rvGameInfo.adapter = adapter

        val gameApi = GameApi.create().getGames()
        gameApi.enqueue(object : Callback<List<Game>> {
            override fun onResponse(call: Call<List<Game>>, response: Response<List<Game>>) {
                if (response.body() != null) {
                    adapter.fillGames(response.body()!!)
                }
            }

            override fun onFailure(call: Call<List<Game>>, t: Throwable) {
                Toast.makeText(context, "CALL FAILED", Toast.LENGTH_LONG)
            }
        })
        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = Fragment_Store()
    }
}