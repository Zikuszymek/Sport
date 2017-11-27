package com.mobile.ziku.sport.viewholders

import android.content.Context
import android.content.Intent
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.mobile.ziku.sport.BR
import com.mobile.ziku.sport.activities.NewsWebViewActivity
import com.mobile.ziku.sport.models.Item

class NewsViewHolder(val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root){

    val context : Context by lazy { viewDataBinding.root.context }

    fun bindData(news : Item){
        viewDataBinding.setVariable(BR.news, news)
        viewDataBinding.executePendingBindings()
        viewDataBinding.root.setOnClickListener {
            val intent = Intent(context, NewsWebViewActivity::class.java)
            intent.putExtra(NewsWebViewActivity.URL, news.link ?: "")
            intent.putExtra(NewsWebViewActivity.TITLE, news.title)
            context.startActivity(intent)
        }
    }
}