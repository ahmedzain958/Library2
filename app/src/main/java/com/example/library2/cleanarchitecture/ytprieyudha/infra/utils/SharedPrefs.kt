package com.example.library2.cleanarchitecture.ytprieyudha.infra.utils

import android.content.Context
import android.content.SharedPreferences


class SharedPrefs(val context: Context) {
    companion object{
        private const val PREF = "MyCleanApp"
        private const val PREF_TOKEN = "user_token"
    }

    private val sharedPrefs: SharedPreferences = context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
}