package com.hk.mvvmversion.network

import com.squareup.moshi.Moshi
import okhttp3.MultipartBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*

interface ApiService {

    @GET
    fun get(
        @Url endPoint: String,
        @QueryMap(encoded = true) queryParams: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JSONObject>

    @POST
    fun post(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null,
        @QueryMap queryMap: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JSONObject>

    @PUT
    fun put(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JSONObject>

    @DELETE
    fun delete(@Url endPoint: String): Call<JSONObject>

    @PATCH
    fun patch(
        @Url endPoint: String,
        @Body payload: Map<String, @JvmSuppressWildcards Any>? = null
    ): Call<JSONObject>

    @Multipart
    @POST
    fun multipart(
        @Url endPoint: String,
        @Part file: MultipartBody.Part?
    ): Call<JSONObject>
}