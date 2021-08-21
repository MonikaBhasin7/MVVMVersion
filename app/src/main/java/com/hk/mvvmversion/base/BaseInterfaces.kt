package com.hk.mvvmversion.base

interface Execute {
    fun run()
}

interface AdapterBinding {
    fun<T> run(item: T)
}