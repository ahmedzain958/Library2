package com.example.library2.concurrentprogramming.flows.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.library2.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class NormalFlowBuilderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_normal_flow_builder)
        val flow: Flow<Int> = flow<Int> {
            for (i in 0..10) {
                emit(i)
            }
        }/*producer step finished here*/
            .filter { i: Int ->
                i < 5
            }/*intermediate step finished here*/
        /////////////////////////////////////////////////////////////////////////////////

        val normalFlowExample: Flow<Int> = flow<Int> {
            for (i in 0..10) {
                emit(i)
            }
        }

        /////////////////////////////////////////////////////////////////////////////////
        //to run collector, it should run in coroutines builder
        runBlocking {
            flow<Int> {
                for (i in 0..10) {
                    emit(i)
                    delay(1000)
                    Log.d("here producer", i.toString())
                }
            }/*producer step finished here*/
                .filter { i: Int ->
                    i < 5
                }.collect {
                    delay(1000)
                    Log.d("here collector", it.toString())
                }/*collector step finished here*/
        }
    }
}