package com.mobile.ziku.sport.adapters

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.models.Ranking
import com.mobile.ziku.sport.viewholders.StandingsViewHolder

class StandingsRecycleAdapter : RecyclerView.Adapter<StandingsViewHolder>() {

    var scoresList = listOf<Ranking>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): StandingsViewHolder {
        val inflater = LayoutInflater.from(parent?.context)
        val viewDataBinding = DataBindingUtil.inflate<ViewDataBinding>(inflater, R.layout.standings_view_holder, parent, false)
        return StandingsViewHolder(viewDataBinding)
    }

    override fun onBindViewHolder(holder: StandingsViewHolder?, position: Int) {
        holder?.bindData(scoresList[position])
    }

    override fun getItemCount(): Int = scoresList.size

}