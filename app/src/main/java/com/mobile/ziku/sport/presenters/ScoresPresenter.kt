package com.mobile.ziku.sport.presenters

import com.mobile.ziku.sport.constractors.ScoresContractor
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ScoresPresenter @Inject constructor(
        val compositeDisposable: CompositeDisposable,
        val dataManager: ScoresContractor.DataManager
) : ScoresContractor.Presenter {

    companion object {
        const val REFRESH_INREVAL = 30L
    }

    var currentSynchronization: Disposable? = null

    var view: ScoresContractor.View? = null

    override fun attachView(view: ScoresContractor.View) {
        this.view = view
    }

    override fun removeView() {
        currentSynchronization?.dispose()
        this.view = null
    }

    override fun getCurrentData() {
        compositeDisposable.add(
                dataManager.downloadCurrentScores()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            view?.updateView(it)
                            refreshDataByInterval()
                        }, {
                            view?.displayMessage(it)
                            refreshDataByInterval()
                        })
        )
    }

    private fun refreshDataByInterval() {
        currentSynchronization?.dispose()
        Timber.d("refresh: " + Date(System.currentTimeMillis()))
        currentSynchronization = Observable.interval(REFRESH_INREVAL, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ getCurrentData() })
    }
}