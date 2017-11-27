package com.mobile.ziku.sport.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.models.MatchResult
import com.mobile.ziku.sport.enums.BackgroundView
import com.mobile.ziku.sport.viewholders.ScoresViewHolder

class ScoresRecyclerAdapter : BaseRecycleAdapter<ScoresViewHolder>() {

    var scoresList = mutableListOf<MatchResult>()

    override fun onBindViewHolder(holder: ScoresViewHolder?, position: Int) {
        holder?.bindData(scoresList[position], getBackgroundView(position))
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ScoresViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.score_view_holder, parent, false)
        return ScoresViewHolder(viewDataBinding)
    }

    override fun getItemCount(): Int = scoresList.size

}