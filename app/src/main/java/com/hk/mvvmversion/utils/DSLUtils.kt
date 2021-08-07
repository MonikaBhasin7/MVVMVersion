package com.hk.mvvmversion.utils

import androidx.fragment.app.Fragment
import com.hk.mvvmversion.base.BaseActivity
import kotlin.properties.Delegates

class OpenFragment {
    var container by Delegates.notNull<Int>()
    lateinit var fragment : Fragment
    lateinit var way : BaseActivity.FragmentTransactionWaysEnum
}