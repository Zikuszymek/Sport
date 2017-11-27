package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView
import com.mobile.ziku.sport.models.Item
import io.reactivex.Single

interface LatestContractor {

    interface View:BaseView{
        fun updateRecyclerView(news: List<Item>)
    }

    interface Presenter:BasePresenter<View>{
        fun getCurrentData()
    }

    interface DataManager{
        fun downloadLastNews() : Single<List<Item>>
    }
}