package com.mobile.ziku.sport.viewholders

import android.content.Context
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.mobile.ziku.sport.BR
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.enums.BackgroundView
import com.mobile.ziku.sport.models.Ranking
import kotlinx.android.synthetic.main.standings_view_holder.view.*

class StandingsViewHolder(val viewDataBinding: ViewDataBinding) : RecyclerView.ViewHolder(viewDataBinding.root) {

    val context: Context by lazy { viewDataBinding.root.context }

    fun bindData(ranking: Ranking, backgroundView : BackgroundView) {
        viewDataBinding.setVariable(BR.ranking, ranking)
        viewDataBinding.executePendingBindings()
        colorScores(ranking)
        setBackgroundColor(backgroundView)
    }

    fun colorScores(ranking: Ranking) {
        val points = (ranking.goalsPro ?: 0) - (ranking.goalsAgainst ?: 0)
        val textColor = when {
            points > 0 -> R.color.green
            else -> R.color.red
        }
        viewDataBinding.root.club_GD_value.setTextColor(context.resources.getColor(textColor))
    }

    private fun setBackgroundColor(backgroundView : BackgroundView) {
        val color = when(backgroundView){
            BackgroundView.WHITE -> R.color.white
            BackgroundView.GREY -> R.color.shine_light_grey
        }
        viewDataBinding.root.setBackgroundResource(color)
    }
}

