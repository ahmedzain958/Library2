package com.example.library2.emedinaa.mvvmroom

import android.app.Application
import com.example.library2.emedinaa.mvvmroom.di.Injection

class MuseumApplication:Application() {

    override fun onCreate() {
        super.onCreate()
        Injection.setup(this)
    }
}