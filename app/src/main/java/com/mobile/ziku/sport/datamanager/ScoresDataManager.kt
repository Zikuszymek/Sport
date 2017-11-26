package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.constractors.ScoresContractor
import com.mobile.ziku.sport.http.RetrofitService
import com.mobile.ziku.sport.models.BaseResponse
import com.mobile.ziku.sport.models.MatchResult
import com.mobile.ziku.sport.models.ScoresViewUpdate
import io.reactivex.Single
import javax.inject.Inject

class ScoresDataManager @Inject constructor(
        val retrofitService: RetrofitService.SportService
) : ScoresContractor.DataManager {

    companion object {
        const val DATE = "date"
    }

    override fun downloadCurrentScores(): Single<ScoresViewUpdate> {
        return retrofitService.getScores()
                .map {
                    val matches = mutableListOf<MatchResult>()
                    it.competition?.season?.round?.group?.forEach {
                        it.matches?.forEach {
                            matches.add(com.mobile.ziku.sport.models.MatchResult.MatchMapper.fromMatch(it))
                        }
                    }
                    matches.toList()
                    ScoresViewUpdate(matches, getHeaderDate(it))
                }
    }

    private fun getHeaderDate(baseResponse: BaseResponse) : String{
        return baseResponse.method?.parameters?.firstOrNull { it.name == DATE }?.value ?: ""
    }
}