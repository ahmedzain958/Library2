package com.example.library2.viewmodelcoroutines

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.library2.manageconcurrenttaskscoroutines.fileUrl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.URL
import java.nio.charset.Charset

class MainViewModel: ViewModel() {
    val myData = MutableLiveData<String?>()



    suspend fun fetchSomething(): String?{
        return withContext(Dispatchers.IO){
            val url = URL(fileUrl)
            return@withContext url.readText(Charset.defaultCharset())
        }
    }
}