package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.constractors.StandingsContractor
import com.mobile.ziku.sport.http.RetrofitService
import com.mobile.ziku.sport.models.Ranking
import io.reactivex.Single
import javax.inject.Inject

class StandingsDataManager @Inject constructor(
        val retrofitService: RetrofitService.SportService
) : StandingsContractor.DataManager {

    override fun downloadCurrentStandings(): Single<List<Ranking>> {
        return retrofitService.getStandings().map { it.competition?.season?.round?.resultsTable?.rankings?.sortedBy { it.rank } ?: emptyList<Ranking>() }
    }
}