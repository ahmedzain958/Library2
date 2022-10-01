package com.example.library2.runnableobject

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.databinding.ActivityMainRunnableObjectBinding
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
//https://www.linkedin.com.mcas.ms/learning/concurrent-programming-with-android-threads-workers-and-kotlin-coroutines/delay-execution-of-a-runnable-object?autoplay=true&resume=false&u=2037052
class MainActivityRunnableObject : AppCompatActivity() {

    private lateinit var binding: ActivityMainRunnableObjectBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainRunnableObjectBinding.inflate(layoutInflater)
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
        //define an operation to be always executed at the end of the app
        val runnble = object : Runnable{
            override fun run() {
                log("Operation from Runnable")
            }
        }
        val handler =  Handler()
        handler.post(runnble)
        //delay execution of runnable object
        //the next execution doesn't take place concurrently (happening one after another, so the user can't tell the difference), they all executed instantly
    Handler().postDelayed({
        log("------")
        log("Operation before delayed Runnable1 ${getCurrentTime()}")
        Thread.sleep(300)
            log("Operation from delayed Runnable1 ${getCurrentTime()}")}, 1000/*indicates how long you want to wait from the time the code was executed*/)
        Handler().postDelayed({
            Thread.sleep(200)
            log("Operation from delayed Runnable2 ${getCurrentTime()}")}, 1000)
        Handler().postDelayed({
            Thread.sleep(100)
            log("Operation from delayed Runnable3 ${getCurrentTime()}")}, 1000)// all previous code starts instantly, but they are happening one after the other (in sequence) and happening so fast that the user can't tell the difference
        //
        log("Synchronous operation 1")
        log("Synchronous operation 2")
        log("Synchronous operation 3")
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
