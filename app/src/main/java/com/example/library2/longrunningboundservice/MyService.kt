package com.example.library2.longrunningboundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log
import com.example.library2.stickingaroundforegroundservice.AUDIO_FILE

class MyService : Service() {

    private val binder = MyServiceBinder()
    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    fun doSomething(){
        Log.i(LOG_TAG, "service is doing something")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(LOG_TAG, "service destroyed")
    }
    fun startAudio(){
        try {
            player.stop()
            player.release()
        }catch (e: UninitializedPropertyAccessException){

        }
        player = MediaPlayer().also {
            assets.openFd(AUDIO_FILE).use { asset -> //extension function closes objects automatically that need to be closed when you're done with them
                it.setDataSource(asset.fileDescriptor, asset.startOffset, asset.length)
            }
            it.prepare()
            it.start()
        }
    }

    fun stopMusic() {
        try {
            player.stop()
        }catch (e: UninitializedPropertyAccessException){

        }
    }

    inner class MyServiceBinder: Binder(){
        fun getService()= this@MyService
    }
}