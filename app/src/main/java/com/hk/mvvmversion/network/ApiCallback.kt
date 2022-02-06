package com.hk.mvvmversion.network

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.hk.mvvmversion.utils.Logger
import org.json.JSONObject
import retrofit2.*
import javax.inject.Inject

class ApiCallback<R>(
    val responseType: Class<R>,
    val successCallback: (R) -> (Unit),
    val failureCallback: (String) -> (Unit),
    val gson: Gson
) : Callback<JSONObject> {

    val TAG = "ApiCallback"
    lateinit var logger: Logger
    override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
        logger.debug(TAG, "onResponse")
        println("$TAG - onResponse")
        if(response.isSuccessful) {
            if(response.body() != null) {
                gson?.fromJson(
                    response.body().toString(),
                    responseType
                )?.let {
                    successCallback(it)
                } ?: failureCallback("Json Parsing Error")
            }
        } else {
            failureCallback("Api Failure")
        }
    }

    override fun onFailure(call: Call<JSONObject>, t: Throwable) {
        println("$TAG - onFailure - ${call.request().body} -- ${call.request().url} -- $t")
        failureCallback(t.localizedMessage)
    }
}