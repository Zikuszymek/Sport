package com.mobile.ziku.sport.diffutils

import android.support.v7.util.DiffUtil
import com.mobile.ziku.sport.models.Ranking

class StandingsDiffCallback(
        private val oldStandings: List<Ranking>,
        private val newStandings: List<Ranking>
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldStandings[oldItemPosition]
        val newItem = newStandings[newItemPosition]
        return (oldItem.goalsPro == newItem.goalsPro && oldItem.clubName == newItem.clubName &&
                oldItem.goalsAgainst == newItem.goalsAgainst && oldItem.lastRand == newItem.lastRand &&
                oldItem.matchesDraw == newItem.matchesDraw && oldItem.matchesLost == newItem.matchesLost &&
                oldItem.matchesTotal == newItem.matchesTotal && oldItem.matchesWon == newItem.matchesWon &&
                oldItem.points == newItem.points && oldItem.rank == newItem.rank)
    }

    override fun getOldListSize(): Int {
        return oldStandings.size
    }

    override fun getNewListSize(): Int {
        return newStandings.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldStandings[oldItemPosition] == newStandings[newItemPosition]
    }
}