package com.mobile.ziku.sport.presenters

import com.mobile.ziku.sport.constractors.LatestContractor
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class LatestPresenter @Inject constructor(
        val dataManager: LatestContractor.DataManager,
        val compositeDisposable: CompositeDisposable
) : LatestContractor.Presenter{

    var view : LatestContractor.View ?= null

    override fun attachView(view: LatestContractor.View) {
        this.view = view
    }

    override fun removeView() {
        this.view = null
    }

    override fun getCurrentData() {
    }

}