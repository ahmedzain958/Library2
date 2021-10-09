package com.example.library2.pluralsight.junit.course1.data

import androidx.lifecycle.LiveData
import com.example.library2.pluralsight.junit.course1.data.Todo

interface TodoRepository {

    fun getAllTodos(): LiveData<List<Todo>>

    fun insert(todo: Todo)

    fun toggleTodo(id: String)

    fun getUpcomingTodosCount(): LiveData<Int>
}