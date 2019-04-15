package com.monentreprise.mygames.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.monentreprise.mygames.R
import com.monentreprise.mygames.adapters.GamesAdapter
import com.monentreprise.mygames.database.getDatabase
import kotlinx.android.synthetic.main.fragment_games.*

class GamesFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val gameDao = getDatabase(context)?.gameDao()
        val adapterGames = GamesAdapter(gameDao?.getAll())
        recyclerGames.adapter = adapterGames

    }

}
