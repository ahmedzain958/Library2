package com.example.library2.longrunningboundservice

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log

class MyService : Service() {

    private val binder = MyServiceBinder()

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    fun doSomething(){
        Log.i(LOG_TAG, "service is doing something")
    }

    inner class MyServiceBinder: Binder(){
        fun getService()= this@MyService
    }
}