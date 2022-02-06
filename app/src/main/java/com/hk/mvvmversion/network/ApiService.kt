package com.hk.mvvmversion.network

import com.google.gson.JsonObject
import com.squareup.moshi.Moshi
import okhttp3.MultipartBody
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET
    fun get(
        @Url endPoint: String,
        @QueryMap(encoded = true) queryParams: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JsonObject>

    @POST
    fun post(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null,
        @QueryMap queryMap: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JsonObject>

    @PUT
    fun put(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JsonObject>

    @DELETE
    fun delete(@Url endPoint: String): Call<JsonObject>

    @PATCH
    fun patch(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JsonObject>

    @Multipart
    @POST
    fun multipart(
        @Url endPoint: String,
        @Part file: MultipartBody.Part?
    ): Call<JsonObject>
}