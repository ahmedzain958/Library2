package com.example.library2.emedinaa.mvvmroom.data.db
import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase

@Database(entities = [MuseumDTo::class], version = 1)
abstract class MuseumDataBase: RoomDatabase() {

    abstract fun museumDao(): MuseumDao

    companion object {
        private var INSTANCE: MuseumDataBase? = null
        private const val DBNAME="Museum.db"

        fun getInstance(context: Context): MuseumDataBase? {
            if (INSTANCE == null) {
                synchronized(MuseumDataBase::class) {
                    INSTANCE = databaseBuilder(context,
                        MuseumDataBase::class.java, DBNAME)
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}