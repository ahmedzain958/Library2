package com.example.library2

import io.mockk.*
import junit.framework.Assert.assertEquals
import org.junit.After
import org.junit.Before
import org.junit.Test

class CarSpyTest {
    @Test
    fun testSpyCar() {
        val car = spyk(Car()) // or spyk<Car>() to call the default constructor

        car.drive(Direction.NORTH)
        car.drive2(Direction.NORTH)

        verify { car.drive(Direction.NORTH) }

        // Checks whether all calls were covered by verify statements.
        confirmVerified(car)
        /**
         * upper code will fail,
         * Verification acknowledgment failed

        Verified call count: 1
        Recorded call count: 2

        because the real call to the car methods (.drive() && .drive2()) is that Recorded call count: 2 but the only verified one was verify { car.drive(Direction.NORTH) }
        not verify { car2.drive(Direction.NORTH) } as well
        - every method called should be verified
         */
    }

    @Test
    fun testRelaxedMock() {
        val car = mockk<Car>(relaxed = true)

        car.drive(Direction.NORTH) // returns null

        verify { car.drive(Direction.NORTH) }

        confirmVerified(car)

    }

    @Test
    fun testRelaxedMockGenericType() {
        val func: () -> Car =
            mockk<() -> Car>(relaxed = true) // in this case invoke function has generic return type

        // this line is workaround, without it the relaxed mock would throw a class cast exception on the next line
        every { func() } returns Car() // or you can return mockk() for example

        func()
    }

    @Test
    fun testPartialMocking() {
        /**
         * Partial mocking
        Sometimes, you need to stub some functions, but still call the real method on others, or on specific arguments.
        This is possible by passing callOriginal() to answers,
        which works for both relaxed and non-relaxed mocks.
         */
        class Adder {
            fun addOne(num: Int) = num + 1
        }

        val adder = mockk<Adder>()

        every { adder.addOne(any()) } returns -1
        every { adder.addOne(3) } answers { callOriginal() }

        assertEquals(-1, adder.addOne(2))
        assertEquals(4, adder.addOne(3)) // original function is called
    }

    object ObjBeingMocked {
        fun add(a: Int, b: Int) = a + b
    }

    @Test
    fun testObjectMocks() {
        mockkObject(ObjBeingMocked) // applies mocking to an Object

        assertEquals(3, ObjBeingMocked.add(1, 2))

        every { ObjBeingMocked.add(1, 2) } returns 55

        assertEquals(55, ObjBeingMocked.add(1, 2))
        //To revert back, use unmockkAll or unmockkObject:
        @Before
        fun beforeTests() {
            mockkObject(ObjBeingMocked)
            every { ObjBeingMocked.add(1, 2) } returns 55
        }

        @Test
        fun willUseMockBehaviour() {
            assertEquals(55, ObjBeingMocked.add(1, 2))
        }

        @After
        fun afterTests() {
            unmockkAll()
            // or unmockkObject(ObjBeingMocked)
        }
    }

    enum class State {
        STATE1
    }

    class ObjectToMock() {
        fun methodToCall(someValue: String?, observer: (State) -> Unit) {

        }
    }

    @Test
    fun testlamdaCallback() {
        val otm: ObjectToMock = mockk()
        every { otm.methodToCall(any(), any()) } answers {
            secondArg<(State) -> Unit>().invoke(State.STATE1)
        }

        otm.methodToCall("bla") {
            println("zain invoked with $it") //invoked with STATE1
        }
    }
}