package com.hk.fcm

import androidx.lifecycle.LiveData

object GlobalLiveDataForFireBaseToken: LiveData<String>() {

    fun onValueChanges(fireBaseToken: String) {
        value = fireBaseToken
    }
}