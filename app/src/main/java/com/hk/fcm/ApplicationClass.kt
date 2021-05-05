package com.hk.fcm

import android.app.Application
import android.util.Log
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

class ApplicationClass : Application(){

    override fun onCreate() {
        super.onCreate()
        AppSingleton.initApplicationContext(applicationContext)
    }

    companion object {
        lateinit var instance: ApplicationClass
            private set
    }

}