package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView
import com.mobile.ziku.sport.models.Ranking
import io.reactivex.Single

interface StandingsContractor {

    interface View : BaseView {
        fun updateRecyclerView(standings: List<Ranking>)
    }

    interface Presenter : BasePresenter<View> {
        fun getCurrentData()
    }

    interface DataManager {
        fun downloadCurrentStandings(): Single<List<Ranking>>
    }
}
