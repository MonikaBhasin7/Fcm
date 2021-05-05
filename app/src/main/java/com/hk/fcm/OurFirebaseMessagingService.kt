package com.hk.fcm

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class OurFireBaseMessagingService : FirebaseMessagingService() {

    companion object {
        val TAG = "OurFireBaseMessagingService"
    }


    override fun onNewToken(s: String) {
        super.onNewToken(s)
        GlobalLiveDataForFireBaseToken.onValueChanges(s)
    }

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        Log.d("OurFirebaseService", "notification received")
    }
}