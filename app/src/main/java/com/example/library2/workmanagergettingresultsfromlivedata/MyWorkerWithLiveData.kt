package com.example.library2.workmanagergettingresultsfromlivedata

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import java.net.URL
import java.nio.charset.Charset

class MyWorkerWithLiveData(context: Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {
    //work manager runs in a worker thread, but in order to run long running operations like calling network APIs
    // you should convert it to coroutines worker
    override fun doWork(): Result {
        Log.i(LOG_TAG, "doing some work")
        Log.i(LOG_TAG, Thread.currentThread().name)
        val url = URL(FILE_URL)
        val data = url.readText(Charset.defaultCharset())
        val workDataOf = workDataOf(DATA_KEY to data)
        return Result.success(workDataOf)
    }
}