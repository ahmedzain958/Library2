package com.psdemo.todo.add

import androidx.lifecycle.ViewModel
import com.example.library2.pluralsight.junit.course1.data.Todo
import com.example.library2.pluralsight.junit.course1.data.TodoRepository
import java.util.*

class AddViewModel(
    private val todoRepository: TodoRepository
) : ViewModel() {

    val todo = Todo(
        UUID.randomUUID().toString(),
        "",
        null,
        false,
        0
    )


    fun save(): String? {
        if (todo.title == "") return "Title is required"

        todo.created = System.currentTimeMillis()
        todoRepository.insert(todo)
        return null
    }

}