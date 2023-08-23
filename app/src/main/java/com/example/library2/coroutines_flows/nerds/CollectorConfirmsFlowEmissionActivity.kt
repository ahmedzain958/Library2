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
import kotlinx.coroutines.runBlocking

class CollectorConfirmsFlowEmissionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collector_confirms_flow_emission)
        //1st Example clarifies that .collect() called only while the intermediate (condition .filter) is valid and
        // producer producer all the time as long there is originally a collect method
        runBlocking {
            /*(1)Producer*/ flow<Int> {
            for (i in 0 until 11) {
                emit(i)
                delay(1000)
            }
        }
            /*(2)intermediate*/.filter { i ->
                i < 5 //same as for condition
            }.buffer()
            /*(3)Collector*/.collect {/*collector executed before producer, in other words producer doesn't work until collector*/
                delay(2000)
                Log.d("here collector ad", it.toString())
            }
        }
        /////////////////////////////////////////////////////////////////////////////////
    }
}