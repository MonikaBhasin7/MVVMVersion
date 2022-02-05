package com.hk.mvvmversion.network

import com.google.gson.Gson

import com.google.gson.reflect.TypeToken
import javax.inject.Inject
import javax.inject.Singleton


class ApiCallHelper {

    @Inject
    val apiService: ApiService? = null

    @Inject
    val gson: Gson? = null

    fun <P, R> apiCall(lambda: ApiCall<P, R>.() -> (Unit)) {
        val apiCallObj = ApiCall<P, R>()
        apiCallObj.lambda()
        apiCall(
            apiCallObj.networkRequestType!!,
            apiCallObj.responseType!!,
            apiCallObj.url!!,
            apiCallObj.payload,
            apiCallObj.success!!,
            apiCallObj.failure!!
        )
    }

    class ApiCall<P, R>() {
        var networkRequestType: NETWORK_REQUEST_TYPE? = null
        var responseType: Class<R>? = null
        var url: String? = null
        var payload: P? = null
        var success: ((R) -> (Unit))? = null
        var failure: ((String) -> (Unit))? = null
    }

    fun <P, R> apiCall(
        networkRequestType: NETWORK_REQUEST_TYPE,
        responseType: Class<R>,
        url: String,
        payload: P,
        successCallback: (R) -> (Unit),
        failureCallback: (String) -> (Unit)
    ) {
        when (networkRequestType) {
            NETWORK_REQUEST_TYPE.GET -> {
                getApiCall(url,responseType , payload, successCallback, failureCallback)
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

    private fun<P, R> getApiCall(
        url: String,
        responseType: Class<R>,
        payload: P,
        successCallback: (R) -> Unit,
        failureCallback: (String) -> Unit
    ) {
        apiService?.get(url, getMapFromPayload(payload))?.enqueue(ApiCallback(responseType, successCallback, failureCallback))
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