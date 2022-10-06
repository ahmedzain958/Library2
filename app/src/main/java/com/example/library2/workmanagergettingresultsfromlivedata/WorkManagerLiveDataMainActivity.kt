package com.example.library2.workmanagergettingresultsfromlivedata

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ScrollView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.work.*
import androidx.work.impl.constraints.trackers.BatteryChargingTracker
import com.example.library2.databinding.ActivityMainRunnableObjectBinding

class WorkManagerLiveDataMainActivity : AppCompatActivity() {

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
        val constraints = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.CONNECTED)
            .build()
        val workRequest = OneTimeWorkRequestBuilder<MyWorkerWithLiveData>()
            .setConstraints(constraints).build()
       val workManager =  WorkManager.getInstance(applicationContext)
        workManager.enqueue(workRequest)
        val workInfoLiveData = workManager.getWorkInfoByIdLiveData(workRequest.id)
        workInfoLiveData.observe(this, Observer {//work just like if you are working with the view mode
            when (it.state) {
                WorkInfo.State.SUCCEEDED -> {
                    val result = it.outputData.getString(DATA_KEY)
                    log(result ?: "Null")
                }
                WorkInfo.State.RUNNING -> {
                    val progress = it.progress.getString(MESSAGE_KEY)
                    progress?.let {
                        log(progress)
                    }
                }
                else -> {

                }
            }
        })
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
