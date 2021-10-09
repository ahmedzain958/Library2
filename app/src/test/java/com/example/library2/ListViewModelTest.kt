package com.example.library2

import com.example.library2.pluralsight.junit.course1.data.Todo
import com.example.library2.pluralsight.junit.course1.data.TodoRepository
import com.example.library2.pluralsight.junit.course1.list.ListViewModel
import com.example.library2.util.TodoTestRepository
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException

class ListViewModelTest {
    lateinit var repository: TodoRepository

    @get:Rule
    val exceptionRule = ExpectedException.none()

    @Before
    fun setup() {
        val now = System.currentTimeMillis()
        val day = 1000 * 60 * 60 * 24

        val todos = ArrayList<Todo>()
        var todo = Todo("1", "Todo 1", null, false, now)
        todos.add(todo)
        todo = Todo("2", "Todo 2", now + day, false, now)
        todos.add(todo)
        todo = Todo("3", "Todo 3", now + day, false, now)
        todos.add(todo)
        todo = Todo("4", "Todo 4", now + day, true, now)
        todos.add(todo)
        todo = Todo("5", "Todo 5", now - day, false, now)
        todos.add(todo)

        repository = TodoTestRepository(todos)
    }

    @Test
    fun test_allTodos() {
        val expected = 5
        val model = ListViewModel(repository)

        val todos = model.allTodos.value

        assertNotNull(todos)
        assertEquals(expected, todos!!.size)
    }

    @Test
    fun test_upcomingTodosCount() {
        val expected = 2
        val model = ListViewModel(repository)

        val todoCount = model.upcomingTodosCount.value

        assertNotNull(todoCount)
        assertEquals(expected, todoCount)
    }

    @Test
    fun test_ToggleTodo() {
        val id = "fake"
        val model = ListViewModel(repository)
        exceptionRule.expect(NotImplementedError::class.java)

        model.toggleTodo(id)
    }
}