package com.example.library2.emedinaa.mvvmroom.data.db

import androidx.lifecycle.LiveData

interface DBDataSource {
    /**
     * You don't need to make that call in an asynchronous manner since it works that way already under the hood. If you needed only the List<Word> object (no LiveData)
    then it would be better if you make that function suspendable to call it from a coroutine or another suspend function.
    Room generates all the necessary code to update the LiveData object when a database is updated. The generated code runs the query asynchronously on a background thread when needed.
    This pattern is useful for keeping the data displayed in a UI in sync with the data stored in a database.
    You can check this information and learn more about LiveData on the Android Development Documentation Guides under the "Use LiveData with Room" section here.
     */
    fun museums(): LiveData<List<MuseumDTo>>
    suspend fun addMuseums(museums: List<MuseumDTo>)
    suspend fun deleteMuseums()
}