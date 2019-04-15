package com.monentreprise.mygames.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.monentreprise.mygames.database.entities.Game

@Dao
interface GameDao {

    @Query("SELECT * FROM Game")
    fun getAll() : List<Game>

    @Query("SELECT * FROM Game WHERE id = :id")
    fun getById(id: Int) : Game

    @Insert
    fun insert(game: Game)

    @Delete
    fun delete(game: Game)

}