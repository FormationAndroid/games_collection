package com.monentreprise.mygames.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.monentreprise.mygames.R
import com.monentreprise.mygames.database.entities.Game
import com.monentreprise.mygames.database.getDatabase
import kotlinx.android.synthetic.main.fragment_add_game.*
import org.jetbrains.anko.toast

class AddGameFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_add_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAddGame.setOnClickListener {

            val game = Game(
                editName.text.toString(),
                editYear.text.toString().toInt(),
                editConsole.text.toString(),
                editMaxPlayers.text.toString().toInt()
            )
            getDatabase(context)?.gameDao()?.insert(game)

            context?.toast("Jeu ajouté avec succès!")

        }
    }

}
