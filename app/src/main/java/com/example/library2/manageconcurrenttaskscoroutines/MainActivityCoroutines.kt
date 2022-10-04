package com.example.library2.manageconcurrenttaskscoroutines

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
import kotlinx.coroutines.*
import java.net.URL
import java.nio.charset.Charset
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.concurrent.thread

//https://www.linkedin.com.mcas.ms/learning/concurrent-programming-with-android-threads-workers-and-kotlin-coroutines/delay-execution-of-a-runnable-object?autoplay=true&resume=false&u=2037052
const val fileUrl = "https://2833069.youcanlearnit.net/lorem_ipsum.txt"

class MainActivityCoroutines : AppCompatActivity() {

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
        Handler().postDelayed({
            log("Zain out of coroutines = inside main thread")
        }, 1000L)
        //for very simple tasks where you just need to run in parallel with other UI tasks, the Main dispatcher can be used
        CoroutineScope(Dispatchers.Main).launch{
            delay(1000L)//paused the coroutine only not the UI thread for 1 secs until all the upper UI tasks finished
            log("Zain inside coroutines & inside ${Thread.currentThread().name} dispatcher")
        }

        CoroutineScope(Dispatchers.Main).launch{
            val result = fetchSomething()
            log(result ?: "Null")
        }

    }

    suspend fun fetchSomething(): String?{
        return withContext(Dispatchers.IO){
            val url = URL(fileUrl)
            return@withContext url.readText(Charset.defaultCharset())
        }
    }

    /**
     * Clear log display
     */
    private fun clearOutput() {
        binding.logDisplay.text = ""
        scrollTextToEnd()
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
