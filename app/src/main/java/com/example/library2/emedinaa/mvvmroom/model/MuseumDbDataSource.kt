package com.example.library2.emedinaa.mvvmroom.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.library2.emedinaa.mvvmroom.data.db.DBDataSource
import com.example.library2.emedinaa.mvvmroom.data.db.MuseumDTo
import com.example.library2.emedinaa.mvvmroom.data.db.MuseumDao
import com.example.library2.emedinaa.mvvmroom.data.db.MuseumDataBase

class MuseumDbDataSource(context: Context) : DBDataSource {
    private lateinit var museumDao: MuseumDao

    init {
        val db: MuseumDataBase? = MuseumDataBase.getInstance(context)
        db?.let {
            museumDao = it.museumDao()
        }
    }

    override fun museums(): LiveData<List<MuseumDTo>> {
        return museumDao.museums()
    }

    override suspend fun addMuseums(museums: List<MuseumDTo>) {
        museumDao.add(museums)
    }

    override suspend fun deleteMuseums() {
        museumDao.deleteAll()
    }
}