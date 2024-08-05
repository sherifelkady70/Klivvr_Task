package com.route.cities

import android.app.Application
import android.content.Context

class ApplicationClass :Application(){
    companion object {
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}