package com.example.assessmenttask.data.api
import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class RetrofitBuilder : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}