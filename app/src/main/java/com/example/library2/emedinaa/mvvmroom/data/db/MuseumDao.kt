package com.example.library2.emedinaa.mvvmroom.data.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

interface MuseumDao {
    @Query("Select * from tb_museum")
    fun museums():LiveData<List<MuseumDTo>>

    @Insert(onConflict = REPLACE)
    suspend fun add(museums:List<MuseumDTo>)

    @Query("DELETE from tb_museum")
    suspend fun deleteAll()
}