package com.hk.mvvmversion.ui.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hk.mvvmversion.R
import com.hk.mvvmversion.ui.activities.MainActivity
import com.hk.mvvmversion.ui.viewModels.MainViewModel
import com.hk.mvvmversion.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ListFragment : Fragment(R.layout.fragment_list) {

    val TAG = ListFragment::class.java.simpleName

    @Inject lateinit var logger : Logger
    lateinit var viewModel: MainViewModel

    companion object {
        @JvmStatic
        fun newInstance() = ListFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()
        logger.debug(TAG, "OnStart()")


    }
}