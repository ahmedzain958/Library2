package com.example.library2

import io.mockk.*
import org.junit.Test

class CarSpyTest {
    @Test
    fun testSpyCar(){
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
    fun testRelaxedMock(){
        val car = mockk<Car>(relaxed = true)

        car.drive(Direction.NORTH) // returns null

        verify { car.drive(Direction.NORTH) }

        confirmVerified(car)
    }

    @Test
    fun testRelaxedMockGenericType(){
        val func: () -> Car = mockk<() -> Car>(relaxed = true) // in this case invoke function has generic return type

        // this line is workaround, without it the relaxed mock would throw a class cast exception on the next line
        every { func() } returns Car() // or you can return mockk() for example

        func()
    }
}