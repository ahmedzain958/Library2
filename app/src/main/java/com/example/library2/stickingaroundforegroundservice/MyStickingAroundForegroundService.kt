package com.example.library2.stickingaroundforegroundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyStickingAroundForegroundService : Service() {

    private val binder = MyServiceBinder()
    private lateinit var player: MediaPlayer

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    fun startAudio(){
        try {
            player.stop()
            player.release()
        }catch (e: UninitializedPropertyAccessException){

        }
       player = MediaPlayer().also {

       }
    }

    inner class MyServiceBinder: Binder(){
        fun getService()= this@MyStickingAroundForegroundService
    }
}