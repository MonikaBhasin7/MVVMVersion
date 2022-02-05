package com.hk.mvvmversion.ui.viewModels

import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.network.ApiService
import com.hk.mvvmversion.data.MainRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

import org.json.JSONObject


import retrofit2.*
class MainViewModel @Inject constructor(mainRepo: MainRepo): ViewModel() {

    @Inject
    lateinit var apiService : ApiService

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
         *
         * apiCall(type = GET, url = "krsna.com", payload = ...).collect {
         *
         * }
         *
         */

//        val service: GetDataService = RetrofitClientInstance.getRetrofitInstance().create(
//            GetDataService::class.java
//        )
//        val call: Call<List<RetroPhoto>> = service.getAllPhotos()
//        call.enqueue(object : Callback<List<RetroPhoto?>?> {
//            fun onResponse(
//                call: Call<List<RetroPhoto?>?>?,
//                response: Response<List<RetroPhoto?>?>
//            ) {
//                progressDoalog.dismiss()
//                generateDataList(response.body())
//            }
//
//            fun onFailure(call: Call<List<RetroPhoto?>?>?, t: Throwable?) {
//                progressDoalog.dismiss()
//                Toast.makeText(
//                    this@MainActivity,
//                    "Something went wrong...Please try later!",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        })

    }
}