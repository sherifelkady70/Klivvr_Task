package com.route.cities

import android.app.Application
import android.content.Context
import com.route.cities.utils.NetworkCheck
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.HiltAndroidApp
import dagger.hilt.components.SingletonComponent

@HiltAndroidApp
class ApplicationClass :Application(){

    override fun onCreate() {
        super.onCreate()
        NetworkCheck.context = this
    }

    companion object {
        val instance: ApplicationClass by lazy { ApplicationClass() }
    }
}