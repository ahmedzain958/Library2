package com.example.library2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_run_blocking.view.*
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class RunBlockingActivity : AppCompatActivity() {
    lateinit var textView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_run_blocking)
        textView = findViewById<TextView>(R.id.textView)
        GlobalScope.launch {
            launch {
                printCoroutines("Zain")
            }
            launch {
                printCoroutines("Zain2")
            }
        }
        Log.d("RunBlockingActivity", "return to :" + Thread.currentThread().name + " thread")


        GlobalScope.launch {
            val millis = measureTimeMillis {
                val networkUser = async { getUserFromNetwork() }
                val databaseUser = async { getUserFromDatabase() }

                if (networkUser.await() == databaseUser.await()) {
                    Log.d("2RunBlockingActivity", "Equals")
                } else {
                    Log.d("2RunBlockingActivity", "Not Equals")
                }
            }
            Log.d("2RunBlockingActivity", "secs=${millis/1000}")
        }
    }

    suspend fun printCoroutines(text: String) {
        delay(2000)
        Log.d(
            "RunBlockingActivity",
            "hello $text - thread:" + Thread.currentThread().name
        )
    }

    suspend fun getUserFromNetwork(): String {
        delay(2000)
        return "Zain"
    }

    suspend fun getUserFromDatabase(): String {
        delay(2000)
        return "Zain"
    }
}