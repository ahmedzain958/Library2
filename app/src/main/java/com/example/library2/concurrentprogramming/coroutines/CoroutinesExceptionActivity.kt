package com.example.library2.concurrentprogramming.coroutines

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CoroutinesExceptionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_exception)
        val deferred = lifecycleScope.async {
            val string = async {
                throw Exception("Exception")
                "Result"
            }
        }
        lifecycleScope.launch {
            try {
                deferred.await()
            } catch (e: java.lang.Exception) {
                Toast.makeText(this@CoroutinesExceptionActivity,
                    e.message,
                    Toast.LENGTH_SHORT).show()

            }
        }
    }
}