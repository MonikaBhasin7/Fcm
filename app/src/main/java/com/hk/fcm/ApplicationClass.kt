package com.hk.fcm

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.multidex.MultiDex

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()
        AppSingleton.initApplicationContext(applicationContext)
    }

    companion object {
        lateinit var instance: ApplicationClass
            private set
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}