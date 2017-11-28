package com.mobile.ziku.sport

import com.mobile.ziku.sport.datamanager.ScoresDataManager
import com.mobile.ziku.sport.models.*
import io.reactivex.Single

object TestFactory {

    const val DATE = "2017.01.02"
    const val MATCHES_COUNT = 4
    const val ONE = 1
    const val TWO = 2
    const val THREE = 3

    fun getSingleScores(): Single<BaseResponse> {
        return Single.fromCallable<BaseResponse> { getBaseScoreResponse(DATE, MATCHES_COUNT) }
    }

    fun getBaseScoreResponse(headerString: String, matchesCount: Int): BaseResponse {
        return BaseResponse(
                method = Method(parameters = arrayListOf(Parameter(ScoresDataManager.DATE, headerString))
                ), competition = Competition(season = Season(round = getRoundWithMaches(matchesCount))
        ))
    }

    fun getRoundWithMaches(matchesCount: Int): Round {
        val matches = arrayListOf<Match>()
        for(match in 1..matchesCount) {
            matches.add(Match())
        }
        return Round(group = arrayListOf(Group(matches = matches)))
    }

    fun getSingleStandings(): Single<BaseResponse> {
        return Single.fromCallable<BaseResponse> { getBaseStandingsResponse() }
    }

    private fun getBaseStandingsResponse(): BaseResponse {
        return BaseResponse(competition = Competition(season = Season(
                round = Round(resultsTable = ResultsTable(rankings = getRankingsArrayList())))
        ))
    }

    private fun getRankingsArrayList(): ArrayList<Ranking> {
        return arrayListOf(
                Ranking(rank = THREE),
                Ranking(rank = ONE),
                Ranking(rank = TWO)
        )
    }


}