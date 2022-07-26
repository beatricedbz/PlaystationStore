package com.example.playstationstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GameRecyclerAdapter(
    private val clickListener: (Game) -> Unit,
) : RecyclerView.Adapter<GameRecyclerAdapter.MyViewHolder>() {

    var games: List<Game> = emptyList()

    fun fillGames(list: List<Game>) {
        this.games = list
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivGame: ImageView = itemView.findViewById(R.id.ivGame)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_store_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Glide.with(holder.itemView.context)
            .load(games[position].thumbnail)
            .into(holder.ivGame)

        val clickedGame = games[position]
        holder.ivGame.setOnClickListener { clickListener(clickedGame) }
    }

    override fun getItemCount(): Int {
        return games.size
    }
}