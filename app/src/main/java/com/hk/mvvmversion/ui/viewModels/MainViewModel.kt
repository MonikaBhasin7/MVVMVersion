package com.hk.mvvmversion.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.data.MainRepo
import com.hk.mvvmversion.network.ApiCallHelper
import com.hk.mvvmversion.network.NETWORK_REQUEST_TYPE
import com.hk.mvvmversion.utils.WeatherApiPayload
import com.hk.mvvmversion.utils.WeatherApiResponse
import javax.inject.Inject


class MainViewModel @ViewModelInject constructor(mainRepo: MainRepo, var apiCallHelper: ApiCallHelper): ViewModel() {


    val TAG = "MainViewModel"


    fun getData() {
        println("$TAG - getData")
        apiCallHelper.apiCall<WeatherApiPayload, WeatherApiResponse> {
            networkRequestType = NETWORK_REQUEST_TYPE.GET
            responseType = WeatherApiResponse::class.java
            url = "http://api.weatherstack.com/current"
            payload = WeatherApiPayload(access_key = "bb7c4b45616fbe4b1c2f83c6ea9417b4", query = "New York")
            success = {
            }
            failure = {
            }
        }
    }


}