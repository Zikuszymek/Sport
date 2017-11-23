package com.mobile.ziku.sport.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.constractors.ScoresContractor
import javax.inject.Inject

class ScoresActivity : AppCompatActivity(), ScoresContractor.View {

    @Inject lateinit var presenter : ScoresContractor.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
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
