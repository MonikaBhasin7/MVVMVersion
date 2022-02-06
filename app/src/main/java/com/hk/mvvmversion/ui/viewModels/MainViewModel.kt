package com.hk.mvvmversion.ui.viewModels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.data.MainRepo
import com.hk.mvvmversion.network.ApiCallHelper
import com.hk.mvvmversion.network.NETWORK_REQUEST_TYPE
import com.hk.mvvmversion.utils.IdAndName
import com.hk.mvvmversion.utils.WeatherApiPayload
import com.hk.mvvmversion.utils.WeatherApiResponse
import javax.inject.Inject


class MainViewModel @ViewModelInject constructor(mainRepo: MainRepo, var apiCallHelper: ApiCallHelper): ViewModel() {


    val TAG = "MainViewModel"


    fun getData() {
        println("$TAG - getData")
        apiCallHelper.apiCall<IdAndName, IdAndName> {
            networkRequestType = NETWORK_REQUEST_TYPE.GET
            responseType = IdAndName::class.java
            url = "http://192.168.1.7:8081/HareKrsna"
            payload = IdAndName(1, "Monika")
            success = {
                println("$TAG - successCallback - $it")
            }
            failure = {
                println("$TAG - failureCallback - $it")
            }
        }
    }


}