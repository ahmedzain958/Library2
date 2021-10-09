package com.example.library2.pluralsight.junit.course1

import android.app.Application
import com.example.library2.pluralsight.junit.course1.data.TodoRepository
import com.example.library2.pluralsight.junit.course1.data.TodoRoomDatabase
import com.example.library2.pluralsight.junit.course1.data.TodoRoomRepository

class TodoApplication : Application() {

    val todoRepository: TodoRepository
        get() = TodoRoomRepository(TodoRoomDatabase.getInstance(this.applicationContext)!!.todoDao())
}