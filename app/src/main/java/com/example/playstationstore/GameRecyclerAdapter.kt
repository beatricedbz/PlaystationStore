package com.example.playstationstore

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class GameRecyclerAdapter : RecyclerView.Adapter<GameRecyclerAdapter.MyViewHolder>() {

    var games: List<Game> = emptyList()

    fun fillGames(list: List<Game>) {
        this.games = list
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivGame: ImageView = itemView.findViewById(R.id.ivGame)
        val tvGameTitle: TextView = itemView.findViewById(R.id.tvTitle)
        val tvGenre: TextView = itemView.findViewById(R.id.tvGenre)
        val tvPlatform: TextView = itemView.findViewById(R.id.tvPlatform)
        val tvDescription: TextView = itemView.findViewById(R.id.tvDescription)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvGameTitle.text = games[position].title
        holder.tvGenre.text = games[position].genre
        holder.tvPlatform.text = games[position].platform
        holder.tvDescription.text = games[position].short_description

        Glide.with(holder.itemView.context)
            .load(games[position].thumbnail)
            .into(holder.ivGame)
    }

    override fun getItemCount(): Int {
        return games.size
    }
}