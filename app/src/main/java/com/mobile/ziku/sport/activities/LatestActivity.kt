package com.mobile.ziku.sport.activities

import android.os.Bundle
import android.view.MenuItem
import com.mobile.ziku.sport.BaseActivity
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.constractors.LatestContractor
import com.mobile.ziku.sport.models.MatchResult
import timber.log.Timber
import javax.inject.Inject

class LatestActivity : BaseActivity(), LatestContractor.View {

    @Inject lateinit var presenter : LatestContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest)
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.removeView()
    }

    override fun updateRecyclerView(scores: List<MatchResult>) {
    }

    override fun displayMessage(it: Throwable?) {
        super.displayMessage(it)
    }
}
