package com.mobile.ziku.sport.presenters

import com.mobile.ziku.sport.constractors.StandingsContractor
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StandingsPresenter @Inject constructor(
        val compositeDisposable: CompositeDisposable,
        val dataManager: StandingsContractor.DataManager
) : StandingsContractor.Presenter{

    var view : StandingsContractor.View ?= null

    override fun attachView(view: StandingsContractor.View) {
        this.view = view
    }

    override fun removeView() {
        this.view = null
    }

    override fun getCurrentData() {
        compositeDisposable.add(
                dataManager.downloadCurrentStandings()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            view?.updateRecyclerView(it)
                        },{
                            view?.displayMessage(it)
                        })
        )
    }
}