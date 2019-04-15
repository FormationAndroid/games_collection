package com.monentreprise.mygames.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Game(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val name: String,
    val year: Int,
    val console: String,
    val maxPlayer: Int
){
    constructor(name: String, year: Int, console: String, maxPlayer: Int)
            : this(0, name, year, console, maxPlayer)
}