package com.example.library2

import io.mockk.*
import org.junit.Assert
import org.junit.Test

//https://www.youtube.com/watch?v=FLwGdJIRNmc&t=607s
class SpyTest {
    @Test
    fun testMockk() {
        /*without relaxed = true it gives exception
        no answer found for: ArrayList(#1).size()
        io.mockk.MockKException: no answer found for: ArrayList(#1).size()

        val arrayListMockk = mockk<ArrayList<String>>()
        Assert.assertEquals(arrayListMockk.size, 0)*/

        val arrayListMockk = mockk<ArrayList<String>>(relaxed = true)
        Assert.assertEquals(arrayListMockk.size, 0)
        every { arrayListMockk.size } returns 5
        arrayListMockk.add("Dummy") // no actual effect on the list as it is already mockked, size won't be 6
        Assert.assertEquals(arrayListMockk.size, 5)
    }

    @Test
    fun testMockkImmutable() {
        val arrayListMockk =
            mockk<ArrayList<String>>(relaxed = true)//something like creating a real new arraylist
        arrayListMockk.add("Dummy")
        Assert.assertEquals(arrayListMockk.size, 1)//fails because mocked objects are immutable
    }

    @Test
    fun testSpyLikeANormalNewInstance() {
        //spy tracks whether certain methods are called, I want to override specific functionality in the arraylist class
        val arrayListSpy = spyk<ArrayList<String>>()//something like creating a real new arraylist
        Assert.assertEquals(arrayListSpy.size, 0)
        arrayListSpy.add("Dummy")
        Assert.assertEquals(arrayListSpy.size, 1)
    }

    @Test
    fun testSpySpiesASizeMethodButLeavesTheRestDefault() {
        //spy is a partial implementation of the array list class, partial mock
        val arrayListSpy = spyk<ArrayList<String>>()
        every { arrayListSpy.size } returns 5
        Assert.assertEquals(
            arrayListSpy.size,
            5
        )//all the arraylist functions will return the default values except list.size() method returns 5
    }

    //spying helps you change/override a specific behaviour as
    @Test
    fun testSpyChangesTheBehaviourOfACertainClass() {
        val arrayListSpy = spyk<ArrayList<String>>()
        arrayListSpy.add("hello")//change the behaviour of this class a little bit
        verify(exactly = 1) { arrayListSpy.add(any())}
    }
    /**
     * spying is confusing because if you stubbed a certain method in a class and using the real logic in other parts
     */
}