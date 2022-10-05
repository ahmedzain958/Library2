package com.example.library2.viewmodelcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.library2.manageconcurrenttaskscoroutines.fileUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MainViewModel: ViewModel() {
    val myData = MutableLiveData<String?>()
    private lateinit var job: Job
    private suspend fun fetchSomething(): String?{
        return withContext(Dispatchers.IO){
            val url = URL(fileUrl)
            return@withContext url.readText(Charset.defaultCharset())
        }
    }

    fun doWork() {
        job = viewModelScope.launch { //runs in UI thread
            myData.value = fetchSomething()
        }
    }

    fun cancelJob(){
        job.cancel()
        myData.value = "Job cancelled"
    }
}