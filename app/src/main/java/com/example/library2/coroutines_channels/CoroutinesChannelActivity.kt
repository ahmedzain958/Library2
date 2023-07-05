package com.example.library2.coroutines_channels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.math.log

class CoroutinesChannelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines_channel)
        //waits for sending & receiving (suspends)
        executeChannelSend()
        //dont wait for sending & receiving (No suspends)
        executeChannelTrySend()

        //radezvous channel
        //producer
        val channel = Channel<Language>()
        lifecycleScope.launch {
            channel.send(Language.ARABIC)
            channel.send(Language.ENGLISH)
        }
        lifecycleScope.launch {
            Log.d("CoroutinesChannel", channel.receive().toString())
            Log.d("CoroutinesChannel", channel.receive().toString())
        }
    }

    private fun executeChannelTrySend() {
        val channel = Channel<Char>()
        val charList = arrayOf('A', 'B', 'C', 'D') //this array will be sent from one coroutine to another
        runBlocking {
            launch {
                for (char in charList){
                    channel.trySend(char)
                }
            }
            launch {
                for (char in channel){//smart enough to receive then wait a second of the delay
                    Log.d("here", char.toString())
                }
            }
        }
    }

    private fun executeChannelSend() {
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
    enum class Language{
        ENGLISH,
        ARABIC,
        FRENCH,
        GERMANY
    }
}