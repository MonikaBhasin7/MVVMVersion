package com.hk.mvvmversion.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<AR>(private val adapterList: ArrayList<AR>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    abstract fun getLayoutId(item: AR): Int
    abstract fun createView(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder
    
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return createView(viewGroup, viewType)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as AdapterBinding).run(adapterList[position])
    }

    override fun getItemCount(): Int {
        return adapterList.size
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutId(adapterList[position])
    }
}