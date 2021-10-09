package com.example.library2

import java.util.regex.Pattern

class PasswordValidator {
    fun isValid(password: String) = PATTERN.matcher(password).matches()
    private companion object {
        val PATTERN: Pattern =
            Pattern.compile("^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@\$%^&*-]).{8,}\$")
    }
}
/*
fun getTodos(list:List<String>):LiveData<List<String>>{
    return mutab(list)
}*/
