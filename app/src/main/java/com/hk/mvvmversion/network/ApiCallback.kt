package com.hk.mvvmversion.network

import com.google.gson.Gson
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.*
import javax.inject.Inject

class ApiCallback<R>(
    val responseType: Class<R>,
    val successCallback: (R) -> (Unit),
    val failureCallback: (String) -> (Unit)
) : Callback<JSONObject> {

    @Inject
    val gson: Gson? = null
    override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
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
        failureCallback(t.localizedMessage)
    }
}