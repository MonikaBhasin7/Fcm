package com.hk.fcm

import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

object FireStore {

    val TAG = "FireStore"

    fun pushUserData(user: User) {
        Log.d(TAG, "fcm_token ${AppSingleton.prefWrapper.getString(Constants.FIREBASE_TOKEN).toString()}")
        FirebaseFirestore.getInstance().collection("User")
            .document(user.name)
            .set(user)
            .addOnSuccessListener {
                Log.d(TAG, "you will receive the notification")
            }
            .addOnFailureListener {

            }
    }
}