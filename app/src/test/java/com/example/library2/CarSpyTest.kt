package com.example.library2

import io.mockk.confirmVerified
import io.mockk.spyk
import io.mockk.verify
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
         */
    }
}