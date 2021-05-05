package com.hk.fcm

import android.content.Context

object AppSingleton {

    private lateinit var appContext: Context
    val prefWrapper: SharedPrefWrapper by lazy { SharedPrefWrapper.getInstance(appContext)!! }


    fun initApplicationContext(context: Context) {
        appContext = context
    }

}