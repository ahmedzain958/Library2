package com.example.library2

import androidx.lifecycle.MutableLiveData
import com.example.library2.pluralsight.junit.course1.data.Todo
import com.example.library2.pluralsight.junit.course1.data.TodoRepository
import com.example.library2.pluralsight.junit.course1.list.ListViewModel
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ListViewModelMockitoTest {
    @get:Rule
    val exceptionRule: ExpectedException = ExpectedException.none()
    val now = System.currentTimeMillis()
    val day = 1000 * 60 * 60 * 24

    @Before
    fun setup() {


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
    }

    @Test
    fun test_allTodosEmpty() {
        val repository = mock(TodoRepository::class.java)

        val expected = 0
//        val repository = mock(TodoRepository::class.java)
        `when`(repository.getAllTodos())
            .thenReturn(MutableLiveData(arrayListOf()))
        val model = ListViewModel(repository)

        val todos = model.allTodos.value
        assertNotNull(todos)
        assertEquals(expected, todos!!.size)
    }

    @Test
    fun test_allTodosMultiple() {
        val repository = mock(TodoRepository::class.java)

        val expected = 3
//        val repository = mock(TodoRepository::class.java)
        `when`(repository.getAllTodos())
            .thenReturn(
                MutableLiveData(
                    arrayListOf(
                        Todo("3", "Todo 3", now + day, false, now),
                        Todo("4", "Todo 4", now + day, true, now),
                        Todo("5", "Todo 5", now - day, false, now),
                    )
                )
            )
        val model = ListViewModel(repository)

        val todos = model.allTodos.value
        assertNotNull(todos)
        assertEquals(expected, todos!!.size)
    }

    @Test
    fun test_upcomingTodosCountMultiple() {
        val repository = mock(TodoRepository::class.java)
        val expected = 5
        `when`(repository.getUpcomingTodosCount())
            .thenReturn(MutableLiveData(expected))
        val model = ListViewModel(repository)

        val todoCount = model.upcomingTodosCount.value

        assertNotNull(todoCount)
        assertEquals(expected, todoCount)
    }

    @Test
    fun test_ToggleTodo() {
        val repository = mock(TodoRepository::class.java)
        val id = "fake"
        val model = ListViewModel(repository)
        model.toggleTodo(id)
        verify(repository)//verifies repository was accessed and its toggleTODO func. was called and the right ID was passed
            .toggleTodo(id)
    }

    @Test
    fun test_ToggleTodoNoFound() {
        val repository = mock(TodoRepository::class.java)
        val exceptionMessage = "Todo not found"
        val id = "fake"
        `when`(repository.toggleTodo(id))
            .thenThrow(IllegalArgumentException(exceptionMessage))
        val model = ListViewModel(repository)
        exceptionRule.expect(IllegalArgumentException::class.java)
        exceptionRule.expectMessage(exceptionMessage)
        model.toggleTodo(id)

    }
}