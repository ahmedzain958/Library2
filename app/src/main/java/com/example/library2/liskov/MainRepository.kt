package com.example.library2.liskov

import java.lang.Exception

class MainRepository(
    private val auth: FirebaseAuth,
    private val fileLogger: FileLogger
) {

    suspend fun loginUser(email: String, password: String){
        try {
            auth.signInWithEmailAndPass(email, password)
        } catch (e: Exception){
            fileLogger.logError(e.message.toString())
        }
    }
}