package com.hk.fcm

import android.R
import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging


object ActivityObserver : LifecycleObserver{

    val TAG = "ApplicationObserver"

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getTheFirebaseToken()
    }


    private fun getTheFirebaseToken() {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result
            if (token != null) {
                Log.d(TAG, "Firebase Token - $token")
                GlobalLiveDataForFireBaseToken.onValueChanges(token)
            }
        })
    }
}