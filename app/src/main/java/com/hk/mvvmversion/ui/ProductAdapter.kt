package com.hk.mvvmversion.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hk.mvvmversion.R
import com.hk.mvvmversion.base.AdapterBinding
import com.hk.mvvmversion.base.BaseAdapter
import com.hk.mvvmversion.base.Execute
import com.hk.mvvmversion.databinding.FragmentListBinding

class ProductAdapter : BaseAdapter() {


    override fun createView(viewGroup: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CreatureWithFoodViewHolder(DataBindingUtil.inflate(
                LayoutInflater.from(viewGroup.context),
                viewType,
                viewGroup,
                false
        ))
    }


    inner class CreatureWithFoodViewHolder(private val binding: FragmentListBinding) : RecyclerView.ViewHolder(binding.root), AdapterBinding {
        override fun <Product> run(item: Product) {
            TODO("Not yet implemented")
        }
    }

}