package com.mobile.ziku.sport.activities

import android.os.Bundle
import com.mobile.ziku.sport.BaseActivity
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.adapters.StandingsRecycleAdapter
import com.mobile.ziku.sport.constractors.StandingsContractor
import com.mobile.ziku.sport.models.Ranking
import kotlinx.android.synthetic.main.activity_standings.*
import javax.inject.Inject

class StandingsActivity : BaseActivity(), StandingsContractor.View {

    @Inject lateinit var presenter: StandingsContractor.Presenter

    val standingsAdapter: StandingsRecycleAdapter by lazy { StandingsRecycleAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_standings)
        initRecyclerView()
        presenter.getCurrentData()
        initOnSwpieRefresh()
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

    private fun initRecyclerView() {
        standings_recycler_view.apply {
            layoutManager = this@StandingsActivity.layoutManager
            adapter = standingsAdapter
        }
    }

    private fun initOnSwpieRefresh() {
        swpie_refresh_standings.setOnRefreshListener {
            refreshData()
        }
    }

    private fun refreshData() {
        swpie_refresh_standings.isRefreshing = true
        presenter.getCurrentData()
    }

    private fun swipeRefreshCancel() {
        swpie_refresh_standings.isRefreshing = false
    }

    override fun updateRecyclerView(standings: List<Ranking>) {
        swipeRefreshCancel()
        standingsAdapter.scoresList = standings
        standingsAdapter.notifyDataSetChanged()
    }

    override fun displayMessage(it: Throwable?) {
        super.displayMessage(it)
        swipeRefreshCancel()
    }
}
