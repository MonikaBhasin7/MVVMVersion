package com.hk.mvvmversion.ui.activities

import android.content.Context
import com.hk.mvvmversion.base.BaseActivity
import com.hk.mvvmversion.R
import com.hk.mvvmversion.ui.fragments.ListFragment
import com.hk.mvvmversion.utils.Logger
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {

    val TAG = MainActivity::class.java.simpleName
    @Inject
    lateinit var context: Context
    @Inject
    lateinit var logger : Logger
    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onStart() {
        super.onStart()

        logger.debug(TAG, "OnStart()")
        openFragment(R.id.container, ListFragment.newInstance(), FragmentTransactionWaysEnum.ReplaceWithoutBackStack)
    }
}