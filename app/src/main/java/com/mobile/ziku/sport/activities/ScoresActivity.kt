package com.mobile.ziku.sport.activities

import android.os.Bundle
import com.mobile.ziku.sport.BaseActivity
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.adapters.ScoresRecyclerAdapter
import com.mobile.ziku.sport.constractors.ScoresContractor
import com.mobile.ziku.sport.models.ScoresViewUpdate
import kotlinx.android.synthetic.main.activity_scores.*
import javax.inject.Inject

class ScoresActivity : BaseActivity(), ScoresContractor.View {

    @Inject lateinit var presenter: ScoresContractor.Presenter

    val scoresAdapter: ScoresRecyclerAdapter by lazy { ScoresRecyclerAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scores)
        initRecyclerView()
        initOnSwpieRefresh()
        refreshData()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        swipeRefreshCancel()
        presenter.removeView()
    }

    private fun initOnSwpieRefresh(){
        swpie_refresh_standings.setOnRefreshListener {
            refreshData()
        }
    }

    private fun initRecyclerView() {
        scores_recycler_view.apply {
            adapter = scoresAdapter
            layoutManager = this@ScoresActivity.layoutManager
        }
    }

    private fun refreshData() {
        swpie_refresh_standings.isRefreshing = true
        presenter.getCurrentData()
    }

    override fun updateView(updateView: ScoresViewUpdate) {
        swipeRefreshCancel()
        updateHeaderText(updateView.header)
        scoresAdapter.updateList(updateView.scores)
    }

    private fun updateHeaderText(headerText: String) {
        date_text_view.text = headerText
    }

    override fun displayMessage(it: Throwable?) {
        super.displayMessage(it)
        swipeRefreshCancel()
    }

    private fun swipeRefreshCancel(){
        swpie_refresh_standings.isRefreshing = false
    }
}
