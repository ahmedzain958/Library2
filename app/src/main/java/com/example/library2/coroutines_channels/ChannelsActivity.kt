package com.example.library2.coroutines_channels

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.channels.ReceiveChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.channels.produce
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/*
https://www.youtube.com/watch?v=unkgAYV9SpI&t=303s&ab_channel=Stevdza-San
 */
class ChannelsActivity : AppCompatActivity() {
    var channelTobeListenedAndClosedAutomatically: ReceiveChannel<Language> = Channel()
    var bufferChannel: ReceiveChannel<Language> = Channel()

    init {
        lifecycleScope.launch {
            channelTobeListenedAndClosedAutomatically = produce {
                send(Language.ARABIC)
                send(Language.ENGLISH)
            }

            listenToReceiveChannelProducerClosesChannelAutomatically(
                channelTobeListenedAndClosedAutomatically
            )
            //-----------------------------------------------------------------------------------------//

            bufferChannel = produce(capacity = 2) {
                send(Language.ARABIC)
                Log.d(
                    "bufferChannel",
                    "ARABIC sent "
                )
                send(Language.ENGLISH)
                Log.d(
                    "bufferChannel",
                    "ENGLISH sent "
                )
                send (Language.FRENCH)
                Log.d(
                    "bufferChannel",
                    "FRENCH sent "
                )
                send (Language.GERMANY)
                Log.d(
                    "bufferChannel",
                    "GERMANY sent "
                )
            }
        }

        lifecycleScope.launch {
            Log.d("bufferChannel", ".receive() " + bufferChannel.receive().toString())
            delay(3000)
            Log.d("bufferChannel", "----------------------")
            Log.d("bufferChannel", ".receive() " + bufferChannel.receive().toString())
            delay(3000)
            Log.d("bufferChannel", "----------------------")
            Log.d("bufferChannel", ".receive() " + bufferChannel.receive().toString())
            delay(3000)
            Log.d("bufferChannel", "----------------------")
            Log.d("bufferChannel", ".receive() " + bufferChannel.receive().toString())
            delay(3000)
            Log.d("bufferChannel", "----------------------")
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_channels)
        //-----------------------------------------------------------------------------------------//
        val channelTobeListenedWithReceiveOnly = Channel<Language>()
        val channelTobeListenedWithConsumeEach = Channel<Language>()
        //-----------------------------------------------------------------------------------------//
        lifecycleScope.launch {
            channelTobeListenedWithReceiveOnly.send(Language.ARABIC)
            channelTobeListenedWithReceiveOnly.send(Language.ENGLISH)

            channelTobeListenedWithConsumeEach.send(Language.ARABIC)
            channelTobeListenedWithConsumeEach.send(Language.ENGLISH)
        }
        //-----------------------------------------------------------------------------------------//
        lifecycleScope.launch {
            listenToChannelWithReceiveOnly(channelTobeListenedWithReceiveOnly)
            Log.d("CoroutinesChannel", "-----------------------")
            listenToChannelWithConsumeEach(channelTobeListenedWithConsumeEach)
            Log.d("CoroutinesChannel", "-----------------------")
        }
        //----------------------------------BUFFER CHANNEL------------------------//


    }

    private suspend fun listenToReceiveChannelProducerClosesChannelAutomatically(
        channelTobeListenedAndClosedAutomatically: ReceiveChannel<Language>
    ) {
        Log.d(
            "CoroutinesChannel",
            "ReceiveChannel = - isClosed= " + channelTobeListenedAndClosedAutomatically.isClosedForReceive.toString()
        )
        channelTobeListenedAndClosedAutomatically.consumeEach {
            Log.d("CoroutinesChannel", "ReceiveChannel = " + it.name)
        }
        Log.d(
            "CoroutinesChannel",
            "ReceiveChannel = - isClosed= " + channelTobeListenedAndClosedAutomatically.isClosedForReceive.toString()
        )
        Log.d("CoroutinesChannel", "-----------------------")
    }

    private suspend fun listenToChannelWithConsumeEach(channelTobeListenedWithConsumeEach: Channel<Language>) {
        //no need to put .close
        channelTobeListenedWithConsumeEach.consumeEach {
            Log.d("CoroutinesChannel", "ConsumeEach " + it.name)
        }
        //all these won't be executed
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach - isClosed= " + channelTobeListenedWithConsumeEach.isClosedForReceive.toString()
        )
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach " + channelTobeListenedWithConsumeEach.receive().toString()
        )
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach " + channelTobeListenedWithConsumeEach.receive().toString()
        )
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach - isClosed= " + channelTobeListenedWithConsumeEach.isClosedForReceive.toString()
        )
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach " + channelTobeListenedWithConsumeEach.close().toString()
        )
        Log.d(
            "CoroutinesChannel",
            "ConsumeEach- isClosed= " + channelTobeListenedWithConsumeEach.isClosedForReceive.toString()
        )
        Log.d("CoroutinesChannel", "-----------------------")
    }

    private suspend fun listenToChannelWithReceiveOnly(channel: Channel<Language>) {
        Log.d(
            "CoroutinesChannel",
            ".receive() - isClosed= " + channel.isClosedForReceive.toString()
        )
        Log.d("CoroutinesChannel", ".receive() " + channel.receive().toString())
        Log.d("CoroutinesChannel", ".receive() " + channel.receive().toString())
        Log.d(
            "CoroutinesChannel",
            ".receive() - isClosed= " + channel.isClosedForReceive.toString()
        )
        channel.close()
        Log.d(
            "CoroutinesChannel",
            ".receive() - isClosed= " + channel.isClosedForReceive.toString()
        )
        Log.d("CoroutinesChannel", "-----------------------")
    }

    enum class Language {
        ENGLISH,
        ARABIC,
        FRENCH,
        GERMANY
    }
}