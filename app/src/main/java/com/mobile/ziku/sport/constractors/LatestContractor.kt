package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView
import com.mobile.ziku.sport.models.MatchResult
import io.reactivex.Single

interface LatestContractor {

    interface View:BaseView{
        fun updateRecyclerView(scores: List<MatchResult>)
    }

    interface Presenter:BasePresenter<View>{
        fun getCurrentData()
    }

    interface DataManager{
        fun downloadCurrentScores() : Single<List<MatchResult>>
    }
}