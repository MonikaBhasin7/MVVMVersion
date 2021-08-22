package com.hk.mvvmversion.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseAdapter<R>(private val adapterList: MutableList<R>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    abstract fun getLayoutId(item: R): Int
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

    fun setList(list: List<R>) {
        adapterList.apply {
            clear()
            addAll(list)
        }
        notifyDataSetChanged()
    }

    fun addItem(item: R, position: Int) {
        position.let {
            if(it <= adapterList.size) {
                adapterList.add(position, item)
                notifyItemInserted(position)
            } else {
                adapterList.add(item)
                notifyItemInserted(adapterList.size -1)
            }
        }
    }
}