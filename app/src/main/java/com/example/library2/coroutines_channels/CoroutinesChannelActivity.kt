package com.example.library2.coroutines_channels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.library2.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class CoroutinesChannelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_channel)

        val channel = Channel<Char>()
        val charList = arrayOf('A', 'B', 'C', 'D') //this array will be sent from one coroutine to another
        runBlocking {
            launch {
                for (char in charList){
                    channel.send(char)
                    delay(1000)
                }
            }
            launch {
                for (char in channel){//smart enough to receive then wait a second of the delay
                    Log.d("here", char.toString())
                }
            }
        }
    }
}