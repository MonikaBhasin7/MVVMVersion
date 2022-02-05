package com.hk.mvvmversion.ui.viewModels

import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.data.MainRepo
import com.hk.mvvmversion.network.ApiCallHelper
import com.hk.mvvmversion.network.NETWORK_REQUEST_TYPE
import javax.inject.Inject


class MainViewModel @Inject constructor(mainRepo: MainRepo): ViewModel() {

    @Inject
    lateinit var apiCallHelper: ApiCallHelper

    class Person() {

    }

    fun getData() {
        apiCallHelper.apiCall<Person, Person> {
            networkRequestType = NETWORK_REQUEST_TYPE.GET
            responseType = null
            url = "http://0.0.0.0:8082/HareKrsna"
            payload = null
            success = {
            }
            failure = {
            }
        }
    }


}