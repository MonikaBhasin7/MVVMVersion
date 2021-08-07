package com.hk.mvvmversion

import com.squareup.moshi.Moshi
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET
    fun get(
        @Url endPoint: String,
        @QueryMap(encoded = true) queryParams: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<Moshi>

    @POST
    fun post(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null,
        @QueryMap queryMap: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<Moshi>

    @PUT
    fun put(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<Moshi>

    @DELETE
    fun delete(@Url endPoint: String): Call<Moshi>

    @PATCH
    fun patch(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<Moshi>

    @Multipart
    @POST
    fun multipart(
        @Url endPoint: String,
        @Part file: MultipartBody.Part?
    ): Call<Moshi>
}