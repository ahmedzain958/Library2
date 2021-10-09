package com.example.library2.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.library2.pluralsight.junit.course1.data.Todo
import com.example.library2.pluralsight.junit.course1.data.TodoRepository

class TodoTestRepository(private val todos: ArrayList<Todo>) : TodoRepository {
    override fun getAllTodos(): LiveData<List<Todo>> {
        return MutableLiveData(todos)
    }

    override fun insert(todo: Todo) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun toggleTodo(id: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getUpcomingTodosCount(): LiveData<Int> {
        val count =
            todos.count {
                !it.completed &&
                        it.dueDate != null &&
                        it.dueDate!! >= System.currentTimeMillis()
            }
        return MutableLiveData(count)
    }
}