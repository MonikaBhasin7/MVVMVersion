package com.hk.mvvmversion.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hk.mvvmversion.BaseActivity
import com.hk.mvvmversion.R
import com.hk.mvvmversion.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var logger : Logger
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

}