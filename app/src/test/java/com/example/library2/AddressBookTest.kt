package com.example.library2

import io.mockk.every
import io.mockk.mockk

class AddressBookTest {
    val addressBook = mockk<AddressBook> {
        every { contacts } returns listOf(
            mockk {
                every { name } returns "John"
                every { telephone } returns "123-456-789"
                every { address.city } returns "New-York"
                every { address.zip } returns "123-45"
            },
            mockk {
                every { name } returns "Alex"
                every { telephone } returns "789-456-123"
                every { address } returns mockk {
                    every { city } returns "Wroclaw"
                    every { zip } returns "543-21"
                }
            }
        )
    }
}