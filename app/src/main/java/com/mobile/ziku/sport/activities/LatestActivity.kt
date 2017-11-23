package com.mobile.ziku.sport.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.constractors.LatestContractor
import javax.inject.Inject

class LatestActivity : AppCompatActivity(), LatestContractor.View {

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

}
