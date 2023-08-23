package com.example.library2.coroutines_flows.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.library2.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

class ZipFlowsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_zip_flows)
        runBlocking {
            val flow1 = flow<Int> {
                for (i in 1..3) {
                    emit(i)
                    delay(1000)
                }
            }
        val flow2 = flow<String> {
            val list = listOf<String>("A","B","C")
                for (i in list) {
                    emit(i)
                    delay(1000)
                }
            }

            flow1.zip(flow2){int, str->
                "$int:$str"
            }.collect{
                Log.d("here collector", it.toString())

            }
        }
    }
}