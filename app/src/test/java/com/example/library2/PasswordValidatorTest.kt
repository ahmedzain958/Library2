package com.example.library2

import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
internal class PasswordValidatorTest {
    private val validator = PasswordValidator()
/*
    @ParameterizedTest(name = "given \"{0}\", when validating the password, then it should return {1}")
    @MethodSource("passwordArguments")
    fun `given input password, when validating it, then is should return if it is valid`(
        password: String,
        expected: Boolean
    ) {
        val actual = validator.isValid(password)
        assertEquals(actual, expected)

    }

    private companion object {
        @JvmStatic
        fun passwordArguments() = Stream.of(
            Arguments.of("Test123!", true),
            Arguments.of("#tesT12!", true),
            Arguments.of("12Es@t123", true),
            Arguments.of("test123!", false),
            Arguments.of("t ", false),
            Arguments.of("   ", false)
        )
    }*/
}