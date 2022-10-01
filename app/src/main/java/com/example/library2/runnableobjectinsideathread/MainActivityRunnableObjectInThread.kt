package com.example.library2.runnableobjectinsideathread

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.databinding.ActivityMainRunnableObjectBinding
import com.example.library2.databinding.ActivityMainRunnableObjectInThreadBinding
import kotlinx.android.synthetic.main.todo_item.*
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

//https://www.linkedin.com.mcas.ms/learning/concurrent-programming-with-android-threads-workers-and-kotlin-coroutines/delay-execution-of-a-runnable-object?autoplay=true&resume=false&u=2037052
class MainActivityRunnableObjectInThread : AppCompatActivity() {

    private lateinit var binding: ActivityMainRunnableObjectInThreadBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainRunnableObjectInThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize button click handlers
        with(binding) {
            runButton.setOnClickListener { runCode() }
            clearButton.setOnClickListener { clearOutput() }
        }

    }

    /**
     * Run some code
     */
    private fun runCode() {
        // this code crashes
       /* val runnble = object : Runnable{
            override fun run() {
                log("Operation from Runnable")
            }
        }
       val thread = Thread(runnble)
        thread.start()*/
        val runnble = object : Runnable{
            override fun run() {
                Log.i("","Operation from Runnable") //instead of the log that changes the textview's value
            }
        }
        val thread = Thread(runnble)
        thread.start()

        // or
        Thread{
            //your runnable goes here
        }.start()
        // or equals the upper example
        thread(start = true){
            Log.i("","Operation from Runnable") //instead of the log that changes the textview's value
        }
        //note that runnable object when runs in thread it runs in the bg thread
    }

    /**
     * Clear log display
     */
    private fun clearOutput() {
        binding.logDisplay.text = ""
        scrollTextToEnd()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun getCurrentTime():String {
        val current = LocalDateTime.now()
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        return current.format(formatter)
    }
    /**
     * Log output to logcat and the screen
     */
    @Suppress("SameParameterValue")
    private fun log(message: String) {
        Log.i(LOG_TAG, message)
        binding.logDisplay.append(message + "\n")
        scrollTextToEnd()
    }

    /**
     * Scroll to end. Wrapped in post() function so it's the last thing to happen
     */
    private fun scrollTextToEnd() {
        Handler().post { binding.scrollView.fullScroll(ScrollView.FOCUS_DOWN) }
    }

}
