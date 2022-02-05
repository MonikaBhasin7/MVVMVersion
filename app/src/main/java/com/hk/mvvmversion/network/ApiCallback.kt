package com.hk.mvvmversion.network

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import javax.inject.Singleton
import retrofit2.*
import org.json.JSONObject
import javax.inject.Inject

class ApiCallback<R>(
    val responseType: Class<R>,
    val successCallback: (R) -> (Unit),
    val failureCallback: (String) -> (Unit)
) : Callback<JsonObject> {

    @Inject
    val gson: Gson? = null
    override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
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

    override fun onFailure(call: Call<JsonObject>, t: Throwable) {
        failureCallback(t.localizedMessage)
    }
}