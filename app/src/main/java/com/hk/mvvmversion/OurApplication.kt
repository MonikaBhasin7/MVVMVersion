package com.hk.mvvmversion

import android.app.Application
import android.content.Context
import com.hk.mvvmversion.utils.Logger
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class OurApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}