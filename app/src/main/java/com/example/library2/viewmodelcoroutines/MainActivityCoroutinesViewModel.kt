package com.example.library2.viewmodelcoroutines

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.library2.databinding.ActivityMainRunnableObjectBinding
import com.example.library2.databinding.ActivityMainRunnableObjectInThreadBinding
import com.example.library2.manageconcurrenttaskscoroutines.LOG_TAG
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
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainRunnableObjectInThreadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Initialize button click handlers
        with(binding) {
            runButton.setOnClickListener { runCode() }
            clearButton.setOnClickListener {
                viewModel.cancelJob()
            }
        }
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.myData.observe(this, Observer {
            log(it?:"")
        })
    }

    /**
     * Run some code
     */
    private fun runCode() {
        clearOutput()
        viewModel.doWork()
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
