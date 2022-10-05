package com.example.library2.longbackgroundtasksJobIntentService

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.databinding.ActivityMainRunnableObjectInThreadBinding
import com.example.library2.manageconcurrenttaskscoroutines.LOG_TAG
import kotlinx.android.synthetic.main.todo_item.*
import kotlinx.coroutines.*
import java.net.URL
import java.nio.charset.Charset

//https://www.linkedin.com.mcas.ms/learning/concurrent-programming-with-android-threads-workers-and-kotlin-coroutines/delay-execution-of-a-runnable-object?autoplay=true&resume=false&u=2037052
const val fileUrl = "https://2833069.youcanlearnit.net/lorem_ipsum.txt"

class JobIntentServiceMainActivity : AppCompatActivity() {

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
        MyJobIntentService.startActionFoo(this, "Param1", "Param2")
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
