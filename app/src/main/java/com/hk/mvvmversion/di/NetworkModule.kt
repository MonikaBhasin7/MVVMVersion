package com.hk.mvvmversion.di

import com.hk.mvvmversion.ApiService
import com.hk.mvvmversion.data.RemoteSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
                .build()
    }

    @Provides
    @Singleton
    fun getApiService(okHttpClient: OkHttpClient): ApiService {
        return Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun getRemoteSource(apiService: ApiService) : RemoteSource {
        return RemoteSource(apiService = apiService)
    }
}