package com.example.library2.pluralsight.junit.course1.add

import com.example.library2.pluralsight.junit.course1.data.Todo
import com.example.library2.pluralsight.junit.course1.data.TodoRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.argThat
import com.nhaarman.mockitokotlin2.never
import com.nhaarman.mockitokotlin2.verify
import com.psdemo.todo.add.AddViewModel
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNull
import org.junit.Test
import org.mockito.Mockito.mock

class AddViewModelTest {
    @Test
    fun test_saveWithoutDate() {
        val repository = mock(TodoRepository::class.java)
        val model = AddViewModel(repository)
        val actualTitle = "Test todo"
        model.todo.title = actualTitle
        val actual = model.save()
        assertNull(actual)
        verify(repository).insert(argThat {
            title == actualTitle && dueDate == null

        })
    }

    @Test
    fun test_saveWithDate() {
        val repository = mock(TodoRepository::class.java)
        val model = AddViewModel(repository)
        val actualTitle = "Test todo"
        model.todo.title = actualTitle
        val actualDate = System.currentTimeMillis()
        model.todo.dueDate = actualDate
        val actual = model.save()
        assertNull(actual)
        verify(repository).insert(argThat {
            title == actualTitle && dueDate == actualDate
        })
    }

    @Test
    fun test_saveNoTitle() {
        val repository = mock(TodoRepository::class.java)
        val model = AddViewModel(repository)
        val expected = "Title is required"
        val actual = model.save()
        assertEquals(expected, actual)
        //since we don't want to call the insert function of the repo. when to do doesn't have title, put never function
        verify(repository, never()).insert(any())//checks that the insert method is never called
    }

    @Test
    fun test_saveWithTitle() {
        val repository = mock(TodoRepository::class.java)
        val todo = Todo("1", "New ToDO", completed = false,created = System.currentTimeMillis(), dueDate = null)
        val model = AddViewModel(repository)
        model.todo.title = todo.title
        val actual = model.save()

        assertNull( actual)
//        verify(repository, never()).insert(any())
    }
}