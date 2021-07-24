package com.hk.mvvmversion.utils

import com.hk.mvvmversion.BuildConfig
import timber.log.Timber
import javax.inject.Inject

class Logger @Inject constructor() {

    fun debug(TAG: String, message: String) {
        println("here")
        Timber.tag(TAG).d(message)
    }

    fun error(TAG:String?,errorText:String?){
        Timber.tag(TAG).e(errorText)
    }
}