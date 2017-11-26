package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView
import com.mobile.ziku.sport.models.ScoresViewUpdate
import io.reactivex.Single

interface ScoresContractor {

    interface View: BaseView{
        fun updateView(scores: ScoresViewUpdate)
    }

    interface Presenter: BasePresenter<View> {
        fun getCurrentData()
    }

    interface DataManager{
        fun downloadCurrentScores() : Single<ScoresViewUpdate>
    }

}