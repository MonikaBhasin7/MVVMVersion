package com.hk.mvvmversion.di

import android.content.Context
import com.hk.mvvmversion.BuildConfig
import com.hk.mvvmversion.OurApplication
import com.hk.mvvmversion.utils.Logger
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext

import timber.log.Timber
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object SingletonModule {

    //application context
    @Provides
    @Singleton
    fun getApplicationContext(@ApplicationContext applicationContext: Context): Context {
        return applicationContext
    }
    //pref manager

    //timber for debugging
    @Provides
    @Singleton
    fun getLogger(): Logger {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
            Timber.d("TimberInitializer is initialized.")
        }
        return Logger()
    }
}