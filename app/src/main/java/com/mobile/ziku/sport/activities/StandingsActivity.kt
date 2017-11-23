package com.mobile.ziku.sport.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.constractors.StandingsContractor
import javax.inject.Inject

class StandingsActivity : AppCompatActivity(), StandingsContractor.View {

    @Inject lateinit var presenter : StandingsContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standings)
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
