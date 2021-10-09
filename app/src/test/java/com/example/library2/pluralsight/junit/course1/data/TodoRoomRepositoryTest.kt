package com.example.library2.pluralsight.junit.course1.data

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.jraska.livedata.test
import com.nhaarman.mockitokotlin2.any
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.spy
import org.mockito.Mockito.verify

@RunWith(AndroidJUnit4::class)
class TodoRoomRepositoryTest {
    @get:Rule
    val testRule = InstantTaskExecutorRule()

    val now = System.currentTimeMillis()
    val day = 1000 * 60 * 60 * 24

    private lateinit var db: TodoRoomDatabase

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(context, TodoRoomDatabase::class.java)
            .allowMainThreadQueries()
            .build()
    }

    @Test
    fun test_getUpcomingTodoCountEmpty() {
        val dao = spy(db.todoDao())
        val repo = TodoRoomRepository(dao)
        val expected = 0
        val actual = repo.getUpcomingTodosCount().test()
            .value()//gives us the int value of the upcoming todos count inside the live data
        assertEquals(expected, actual)
        verify(dao).getDateCount(any())
    }

    @Test
    fun test_getUpcomingTodoCountSingleMatch() {
        val dao = spy(db.todoDao())
        db.todoDao().insert(Todo("3", "Todo 3", now + day, false, now))
        db.todoDao().insert(Todo("4", "Todo 4", now + day, true, now))
        db.todoDao().insert(Todo("5", "Todo 5", now - day, false, now))


        val repo = TodoRoomRepository(dao)
        val expected = 1
        val actual = repo.getUpcomingTodosCount().test()
            .value()//gives us the int value of the upcoming todos count inside the live data
        assertEquals(expected, actual)
        verify(dao).getDateCount(any())
    }

    @Test
    fun test_getAllTodosMultiple() {
        val testTodo = Todo("5", "Todo 5", now - day, false, now)
        db.todoDao().insert(testTodo)
        val testTodo2 = Todo("4", "Todo 4", now + day, true, now)
        db.todoDao().insert(testTodo2)
        db.todoDao().insert(Todo("3", "Todo 3", now + day, false, now))
        val dao = spy(db.todoDao())
        val repo = TodoRoomRepository(dao)
        val expected = 3

        val actual: List<Todo> = repo.getAllTodos().test().value()

        assertEquals(expected, actual.size)
        verify(dao).getAllTodos()
        assertTrue(actual.contains(testTodo2))
    }
    @After
    fun teardown() {
        db.close()
    }
}