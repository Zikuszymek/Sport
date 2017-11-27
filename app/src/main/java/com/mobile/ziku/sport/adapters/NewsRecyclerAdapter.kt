package com.mobile.ziku.sport.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.models.Item
import com.mobile.ziku.sport.viewholders.NewsViewHolder

class NewsRecyclerAdapter : RecyclerView.Adapter<NewsViewHolder>(){

    var newsList = listOf<Item>()

    override fun onBindViewHolder(holder: NewsViewHolder?, position: Int) {
        holder?.bindData(newsList[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): NewsViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.news_view_holder, parent, false)
        return NewsViewHolder(viewDataBinding)
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

}