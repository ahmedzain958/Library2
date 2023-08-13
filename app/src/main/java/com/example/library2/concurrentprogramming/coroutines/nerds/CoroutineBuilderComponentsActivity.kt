package com.example.library2.concurrentprogramming.coroutines.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.TextView
import com.example.library2.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class CoroutineBuilderComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_builder_components)
        //1st Example clarifies that coroutine builder consists of 4 terms
        /**
         * 1. Scope: tells coroutine that it will work in this field/place.
         * Examples of Scope: GlobalScope. working while app lasts, if closed activity/viewmodel or any other thing, it will last, Coroutines won't close iff you closed all the app
         * 2. Starting: coroutine to be started with await result/ I am not awaiting any result.
         * Examples of Starting: .launch() not waiting any result
         * 3. Thread: In Which thread coroutine will run.
         * Examples of Threads: Dispatchers.Main :lightweight tasks - Dispatchers.Default: default thread if not determined, v. heavy tasks ex.10000 calculation
         * Dispatchers.IO :Room, DB, Server - Dispatchers.UnConfined: You don't know in which thread it is running in while executing suspend fns.
         * newSingleThreadContext("Zain Thread")
         * 4. Body: Work.
         */
        /////////////////////////////////////////////////////////////////////////////////
        //2nd Example prints not determined thread (Default)
        GlobalScope.launch {
            Log.d("here", "Thread = ${Thread.currentThread().name}")
        }
        /////////////////////////////////////////////////////////////////////////////////
        //3rd Example clarifies Context Switching, without withContext() app will crash only the original thread that create a view can touch its views
        runBlocking {
            printMyTextAfterDelay("Ahmed")
        }
        /////////////////////////////////////////////////////////////////////////////////
        //4th Example clarifies withContext() is a suspend function not a coroutine builder
        //At the end of this example, it will wait for 4 seconds
        GlobalScope.launch {
            printMyTextAfterDelayWIthContext("Zain")
            printMyTextAfterDelayWIthContext("Zain2")
        }
    }

    fun printMyTextAfterDelay(myText: String) {
        GlobalScope.launch(Dispatchers.IO) {
            delay(2000)
            withContext(Dispatchers.Main) {
                findViewById<TextView>(R.id.textView4).text = myText
            }
        }
    }

    suspend fun printMyTextAfterDelayWIthContext(myText: String) {
        withContext(Dispatchers.IO) {
            delay(2000)
            Log.d("here", "myText = $myText")
        }
    }
}