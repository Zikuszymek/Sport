package com.mobile.ziku.sport.viewholders

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.mobile.ziku.sport.BR
import com.mobile.ziku.sport.models.Ranking

class StandingsViewHolder(val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    fun bindData(ranking: Ranking){
        viewDataBinding.setVariable(BR.ranking, ranking)
        viewDataBinding.executePendingBindings()
    }
}