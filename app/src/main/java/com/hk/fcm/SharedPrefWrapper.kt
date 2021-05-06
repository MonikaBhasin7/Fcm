package com.hk.fcm

import android.content.Context
import android.content.SharedPreferences
import javax.inject.Singleton

class SharedPrefWrapper {

    private constructor(context: Context) {
        sharedPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    companion object {

        private const val PREF_NAME = "com.hk.fcm.PREFERENCES_FILE_KEY"

        var sharedPref: SharedPreferences? = null
        @Volatile
        private var sharedPrefWrapper: SharedPrefWrapper? = null
        fun getInstance(context: Context): SharedPrefWrapper? {
            if (sharedPrefWrapper == null) {
                synchronized(SharedPrefWrapper::class.java) {
                    if (sharedPrefWrapper == null) {
                        sharedPrefWrapper = SharedPrefWrapper(context)
                    }
                }
            }
            return sharedPrefWrapper
        }

    }


    fun setString(key: String, data: String) {
        try {
            //sharedPref?.edit()?.putString(key, data)?.apply()
            sharedPref?.edit()?.putString(key, data)?.apply()
            
        } catch (e: Exception) {

        }
    }

    fun getString(key: String): String? {
        try {
            return sharedPref?.getString(key, "1")
        } catch (e: Exception) {

        }
        return "1"
    }

}