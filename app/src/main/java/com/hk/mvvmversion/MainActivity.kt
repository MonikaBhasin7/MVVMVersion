package com.hk.mvvmversion

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.hk.mvvmversion.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var context: Context
    @Inject
    lateinit var logger : Logger
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logger.debug("hello", "hello")
        logger.debug("Application Context", "${context.hashCode()}")
    }
}