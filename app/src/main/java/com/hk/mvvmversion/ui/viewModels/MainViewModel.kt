package com.hk.mvvmversion.ui.viewModels

import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.network.ApiService
import com.hk.mvvmversion.data.MainRepo
import com.hk.mvvmversion.network.ApiCallHelper
import com.hk.mvvmversion.network.NETWORK_REQUEST_TYPE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

import org.json.JSONObject


import retrofit2.*
class MainViewModel @Inject constructor(mainRepo: MainRepo): ViewModel() {

    @Inject
    lateinit var apiService : ApiService

    class Person() {

    }
    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.get("https://pokeapi.co/api/v2/").enqueue(object : retrofit2.Callback<JSONObject> {
                override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {

                }

                override fun onFailure(call: Call<JSONObject>, t: Throwable) {

                }

            })
        }

        /**
         * apiCall {
         *      requestType = NETWORK_REQUEST_TYPE.GET
         *      responseType = Person::class.java
         *      url = ""
         *      payload = Person()
         *      success = {
         *
         *      }
         *      failure = {
         *
         *      }
         *  }
         */
        ApiCallHelper().apiCall(
            NETWORK_REQUEST_TYPE.GET,
            Person::class.java,
            "abc",
            Person(), {}, {})
    }
}