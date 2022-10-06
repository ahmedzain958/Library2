package com.example.library2.longrunningworkmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class MyWorker(context: Context, workerParameters: WorkerParameters): Worker(context, workerParameters) {
    //work manager runs in a worker thread, but in order to run long running operations like calling network APIs
    // you should convert it to coroutines worker
    override fun doWork(): Result {
        Log.i(LOG_TAG, "doing some work")
        Log.i(LOG_TAG, Thread.currentThread().name)
        return Result.success()
    }
}