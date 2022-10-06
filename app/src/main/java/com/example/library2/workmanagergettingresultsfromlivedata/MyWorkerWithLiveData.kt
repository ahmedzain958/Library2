package com.example.library2.workmanagergettingresultsfromlivedata

import android.content.Context
import android.util.Log
import androidx.work.CoroutineWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MyWorkerWithLiveData(context: Context, workerParameters: WorkerParameters):
    CoroutineWorker(context, workerParameters) {
    //work manager runs in a worker thread, but in order to run long running operations like calling network APIs
    // you should convert it to coroutines worker
    override suspend fun doWork(): Result {

        val data = withContext(Dispatchers.IO){
            setProgress(workDataOf(MESSAGE_KEY to "doing some work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "doing some more work"))
            delay(1000)
            setProgress(workDataOf(MESSAGE_KEY to "almost done"))

            val url = URL(FILE_URL)
           return@withContext url.readText(Charset.defaultCharset())
        }

        val workDataOf = workDataOf(DATA_KEY to data)
        return Result.success(workDataOf)
    }
}