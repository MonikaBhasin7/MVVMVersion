package com.hk.mvvmversion.ui.viewModels

import androidx.lifecycle.ViewModel
import com.hk.mvvmversion.ApiService
import com.hk.mvvmversion.data.MainRepo
import com.squareup.moshi.Moshi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.await
import javax.inject.Inject
import javax.security.auth.callback.Callback

class MainViewModel @Inject constructor(mainRepo: MainRepo): ViewModel() {


    @Inject
    lateinit var apiService : ApiService


    fun getData() {
        CoroutineScope(Dispatchers.IO).launch {
            apiService.get("https://pokeapi.co/api/v2/").await()
        }

    }
}