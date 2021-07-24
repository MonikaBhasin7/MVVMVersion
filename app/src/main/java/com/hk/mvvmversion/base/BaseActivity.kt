package com.hk.mvvmversion.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

abstract class BaseActivity : AppCompatActivity() {

    private lateinit var fragmentManager : FragmentManager

    abstract fun getLayoutId(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        fragmentManager = supportFragmentManager
    }

    fun popBackStack() {
        fragmentManager.popBackStack()
    }

    fun openFragment(layout: Int, fragment: Fragment, type: FragmentTransactionWaysEnum) {
        when(type) {
            FragmentTransactionWaysEnum.AddWithBackStack -> FragmentTransactionWays.AddWithBackStack(
                layout,
                fragment,
                fragmentManager
            ).run()

            FragmentTransactionWaysEnum.AddWithOutBackStack -> FragmentTransactionWays.AddWithOutBackStack(
                layout,
                fragment,
                fragmentManager
            ).run()

            FragmentTransactionWaysEnum.ReplaceWithBackStack -> FragmentTransactionWays.ReplaceWithBackStack(
                layout,
                fragment,
                fragmentManager
            ).run()

            FragmentTransactionWaysEnum.ReplaceWithoutBackStack -> FragmentTransactionWays.ReplaceWithOutBackStack(
                layout,
                fragment,
                fragmentManager
            ).run()
        }
    }

    sealed class FragmentTransactionWays: Execute {
        data class AddWithBackStack(
            val layout: Int,
            val fragment: Fragment,
            val fragmentManager: FragmentManager
        ) : FragmentTransactionWays() {
            override fun run() {
                    fragmentManager.beginTransaction().apply {
                        add(layout, fragment)
                        addToBackStack(fragment.tag)
                        commit()
                    }
            }
        }

        data class AddWithOutBackStack(
            val layout: Int,
            val fragment: Fragment,
            val fragmentManager: FragmentManager
        ) : FragmentTransactionWays() {
            override fun run() {
                    fragmentManager.beginTransaction().apply {
                        add(layout, fragment)
                        commit()
                    }
            }
        }

        data class ReplaceWithBackStack(
            val layout: Int,
            val fragment: Fragment,
            val fragmentManager: FragmentManager
        ) : FragmentTransactionWays() {
            override fun run() {

                fragmentManager.beginTransaction().apply {
                    replace(layout, fragment)
                    addToBackStack(fragment.tag)
                    commit()
                }


            }
        }

        data class ReplaceWithOutBackStack(
            val layout: Int,
            val fragment: Fragment,
            val fragmentManager: FragmentManager
        ) : FragmentTransactionWays() {
            override fun run() {
                    fragmentManager.beginTransaction().apply {
                        replace(layout, fragment)
                        commit()
                    }
            }
        }
    }

    override fun onBackPressed() {
        if(fragmentManager.backStackEntryCount == 0) {
            super.onBackPressed()
        } else {
            popBackStack()
        }
    }

    enum class FragmentTransactionWaysEnum {
        AddWithBackStack,
        AddWithOutBackStack,
        ReplaceWithBackStack,
        ReplaceWithoutBackStack
    }
}