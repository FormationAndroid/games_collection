package com.monentreprise.mygames.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.monentreprise.mygames.database.entities.Game

@Database(entities = [Game::class], version = 1)
abstract class GameDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}

private var INSTANCE: GameDatabase? = null

fun getDatabase(context: Context?): GameDatabase? {
    if (INSTANCE == null) {
        INSTANCE = context?.let {
            Room.databaseBuilder(
                it,
                GameDatabase::class.java,
                "game_db")
                .allowMainThreadQueries()
                .build()
        }
    }
    return INSTANCE
}