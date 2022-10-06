package com.example.library2.longbgtasksjobintentserviceresultreceiver

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.ResultReceiver
import android.util.Log
import androidx.core.app.JobIntentService
import java.net.URL
import java.nio.charset.Charset

private const val EXTRA_FILE_URL = "com.example.androidconcurrency2020.extra.FILE_URL"

private const val JOB_ACTION = "com.example.androidconcurrency2020.extra.JOB_ACTION"
private const val JOB_ID = 1001

class MyIntentService : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        if (intent.action == JOB_ACTION) {
            val url = URL(intent.getStringExtra(EXTRA_FILE_URL))
            val contents = url.readText(Charset.defaultCharset())
            val resultReceiver = intent.getParcelableExtra<ResultReceiver>(RESULT_RECEIVER_KEY)
            Bundle().also {
                it.putString(FILE_CONTENT_KEY, contents)
                resultReceiver?.send(Activity.RESULT_OK, it)
            }
            Log.i(LOG_TAG, contents)
        }
    }

    companion object {
        fun startAction(
            context: Context,
            fileUrl: String,
            resultReceiver: JobIntentServiceMainActivity.ResultReceiver
        ) {
            val intent = Intent(context, MyIntentService::class.java).apply {
                action = JOB_ACTION
                putExtra(EXTRA_FILE_URL, fileUrl)
                putExtra(RESULT_RECEIVER_KEY, resultReceiver)
            }
            enqueueWork(context, MyIntentService::class.java, JOB_ID, intent)
        }
    }
}
