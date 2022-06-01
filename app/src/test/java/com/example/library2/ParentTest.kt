package com.example.library2

import io.mockk.spyk
import io.mockk.verify
import org.junit.Test


class ParentTest{
     @Test
     fun `recordPrivateCalls should work on Parent`() {
         val spy = spyk(Parent(), recordPrivateCalls = true)

         spy.foo()

         verify {
             spy["bar"]()
         }
     }

     @Test
     fun `recordPrivateCalls should work on Child`() {
         val spy = spyk(Child(), recordPrivateCalls = true)

         spy.foo()

         verify {
             spy["bar"]()
         }
     }
 }