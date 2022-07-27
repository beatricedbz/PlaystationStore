package com.example.playstationstore

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.playstationstore.databinding.FragmentStoreBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentStore : Fragment(R.layout.fragment_store) {
    private var _binding: FragmentStoreBinding? = null
    lateinit var adapter: GameRecyclerAdapter
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentStoreBinding.bind(view)
        adapter = GameRecyclerAdapter { onClickGame ->
            val intent = Intent(context, StoreGameDescriptionActivity::class.java)
            intent.putExtra("id", onClickGame.id)
            startActivity(intent)
        }
        binding.apply {
            rvGameInfo.layoutManager = GridLayoutManager(context, 2)
            rvGameInfo.adapter = adapter
        }

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = FragmentStore()
    }
}