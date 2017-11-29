package com.mobile.ziku.sport.diffutils

import android.support.v7.util.DiffUtil
import com.mobile.ziku.sport.models.MatchResult

class ScoresDiffCallback(
        private val oldScores: List<MatchResult>,
        private val newScores: List<MatchResult>
) : DiffUtil.Callback() {
    
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldScores[oldItemPosition]
        val newItem = newScores[newItemPosition]
        return (oldItem.result == newItem.result && oldItem.teamA == newItem.teamA &&
                oldItem.teamB == newItem.teamB)
    }

    override fun getOldListSize(): Int {
        return oldScores.size
    }

    override fun getNewListSize(): Int {
        return newScores.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldScores[oldItemPosition] == newScores[newItemPosition]
    }
}