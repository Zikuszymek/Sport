package com.mobile.ziku.sport.models

data class MatchResult (
        val teamA : String? = "",
        val teamB : String? = "",
        val result : String? = ""
){
    object MatchMapper{
        fun fromMatch(match: Match) : MatchResult{
            return MatchResult(match.teamAName, match.teamBName, getResultFromMatch(match))
        }

        private fun getResultFromMatch(match: Match): String? {
            return String.format("%s-%s", match.fsA, match.fsB)
        }
    }
}