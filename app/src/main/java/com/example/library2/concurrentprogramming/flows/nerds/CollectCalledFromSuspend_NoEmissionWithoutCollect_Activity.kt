package com.example.library2.concurrentprogramming.flows.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.library2.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow

class CollectCalledFromSuspend_NoEmissionWithoutCollect_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collectcalledfromsuspend_noemissionwithoutcollect)
        //1st Example clarifies that without .collect() flow won't emit any data//
        val flow: Flow<Int> = flow<Int> {
            for (i in 0..10) {
                emit(i)
                Log.d("here producer", i.toString())
            }
        }/*producer step finished here*/
            .filter { i: Int ->
                i < 5
            }/*intermediate step finished here*/
        /////////////////////////////////////////////////////////////////////////////////
        //2nd Example clarifies that .collect() can't be called except from a coroutine or another suspend fn//
        flow<Int> {
            for (i in 0 until 11) {
                emit(i)
                delay(1000)
            }
        }
            .filter { i ->
                i < 11 //same as for condition
            }/*.collect()*/// give compile time error: Suspend function 'collect' should be called only from a coroutine or another suspend function
    }
}