package com.hk.fcm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.hk.fcm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val TAG = "MainActvity"

    lateinit var dataBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        lifecycle.addObserver(ActivityObserver)
        GlobalLiveDataForFireBaseToken.observe(this) {
            Log.d(TAG, "Firebase Token - $it")
            AppSingleton.prefWrapper.setString(Constants.FIREBASE_TOKEN, it)
        }

        dataBinding.btnSubmit.setOnClickListener {
            FireStore.pushUserData(
                User(
                    dataBinding.txtUserName.text.toString(),
                    dataBinding.txtAge.text.toString(),
                    AppSingleton.prefWrapper.getString(Constants.FIREBASE_TOKEN).toString()
                )
            )
        }
    }
}