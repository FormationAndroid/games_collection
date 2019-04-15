package com.monentreprise.mygames.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.monentreprise.mygames.R
import com.monentreprise.mygames.database.entities.Game
import kotlinx.android.synthetic.main.item_game.view.*

class GamesAdapter (private val games: List<Game>?) : RecyclerView.Adapter<GamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_game, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(games?.get(position))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindItems(game: Game?) {
            game.let {
                itemView.textName.text = it?.name ?: ""
                itemView.textYear.text = it?.year.toString()
                itemView.textConsole.text = it?.console
                itemView.textMaxPlayer.text = "${it?.maxPlayer.toString()} players"
            }
        }
    }

    override fun getItemCount(): Int {
        if (games != null)
            return games.size
        return 0
    }

}