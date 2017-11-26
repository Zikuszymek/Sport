package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.constractors.LatestContractor
import com.mobile.ziku.sport.http.RetrofitService
import com.mobile.ziku.sport.models.MatchResult
import io.reactivex.Single
import javax.inject.Inject

class LatestDataManager @Inject constructor(
        val retrofitService: RetrofitService.SportService
): LatestContractor.DataManager{
    override fun downloadCurrentScores(): Single<List<MatchResult>> {
        return Single.fromCallable { listOf(MatchResult()) }
    }
}