package com.hk.fcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {


    val TAG = "MainActvity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lifecycle.addObserver(ActivityObserver)
        GlobalLiveDataForFireBaseToken.observe(this) {
            Log.d(TAG, "Firebase Token - $it")
            AppSingleton.prefWrapper.setString(Constants.FIREBASE_TOKEN, it)
        }
    }
}