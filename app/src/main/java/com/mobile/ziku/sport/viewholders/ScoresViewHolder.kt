package com.mobile.ziku.sport.viewholders

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.mobile.ziku.sport.BR
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.models.MatchResult
import kotlinx.android.synthetic.main.score_view_holder.view.*

class ScoresViewHolder(val itemBinding: ViewDataBinding) : RecyclerView.ViewHolder(itemBinding.root){

    fun bindData(matchResult: MatchResult, backgroundView : BackgroundView){
        itemBinding.setVariable(BR.matchResult, matchResult)
        itemBinding.executePendingBindings()
        when(backgroundView){
            BackgroundView.WHITE -> setBacgroundColor(R.color.white)
            BackgroundView.GREY -> setBacgroundColor(R.color.shine_light_grey)
        }
    }

    private fun setBacgroundColor(color : Int){
        itemBinding.root.left_team_text_view.setBackgroundResource(color)
        itemBinding.root.right_team_text_view.setBackgroundResource(color)
    }
}