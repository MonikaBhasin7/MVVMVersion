package com.hk.mvvmversion.network

import android.service.voice.AlwaysOnHotwordDetector
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApiCallHelper {

    @Inject
    val apiService: ApiService? = null

    @Inject
    val gson: Gson? = null


    fun<P, R> apiCall(networkRequestType: NETWORK_REQUEST_TYPE, url: String, payload: P, response: (R) -> (Unit)) {
        when(networkRequestType) {
            NETWORK_REQUEST_TYPE.GET -> {
                getApiCall(url, payload)
            }
            NETWORK_REQUEST_TYPE.POST -> {

            }
            NETWORK_REQUEST_TYPE.PUT -> {

            }
            NETWORK_REQUEST_TYPE.DELETE -> {

            }
            NETWORK_REQUEST_TYPE.PATCH -> {

            }
            NETWORK_REQUEST_TYPE.MULTIPART -> {

            }
        }
    }

    private fun<P> getApiCall(url: String, payload: P) {
        apiService?.get(url, getMapFromPayload(payload))?.enqueue(object : retrofit2.Callback<JSONObject> {
            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {

            }

            override fun onFailure(call: Call<JSONObject>, t: Throwable) {

            }
        })
    }

    private fun <P> getMapFromPayload(payload: P): Map<String, Any>? {
        return gson?.fromJson(
            gson.toJson(payload),
            object : TypeToken<Map<String, Any>?>() {}.type
        )
    }
}





enum class NETWORK_REQUEST_TYPE {
    GET, POST, PUT, DELETE, PATCH, MULTIPART
}