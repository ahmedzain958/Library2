package com.example.library2.mvvm.model1

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * @author : Eduardo Medina
 */
@HiltAndroidApp
class MVVMApplication:Application() {

    override fun onCreate() {
        super.onCreate()
    }
}