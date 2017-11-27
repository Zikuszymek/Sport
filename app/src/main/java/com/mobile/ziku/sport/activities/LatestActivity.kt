package com.mobile.ziku.sport.activities

import android.os.Bundle
import android.support.v7.widget.DividerItemDecoration
import com.mobile.ziku.sport.BaseActivity
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.adapters.NewsRecyclerAdapter
import com.mobile.ziku.sport.constractors.LatestContractor
import com.mobile.ziku.sport.models.Item
import kotlinx.android.synthetic.main.activity_latest.*
import javax.inject.Inject

class LatestActivity : BaseActivity(), LatestContractor.View {

    @Inject lateinit var presenter: LatestContractor.Presenter

    val newsAdapter: NewsRecyclerAdapter by lazy { NewsRecyclerAdapter() }
    val itemDecorator: DividerItemDecoration by lazy {
        DividerItemDecoration(this, layoutManager.orientation)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest)
        initRecyclerView()
        initOnSwpieRefresh()
        presenter.getCurrentData()
    }

    override fun onResume() {
        super.onResume()
        presenter.attachView(this)
    }

    override fun onPause() {
        super.onPause()
        presenter.removeView()
        swipeRefreshCancel()
    }

    private fun initOnSwpieRefresh() {
        swpie_refresh_news.setOnRefreshListener {
            refreshData()
        }
    }

    private fun initRecyclerView() {
        itemDecorator.setDrawable(resources.getDrawable(R.drawable.divider))
        news_recycler_view.apply {
            adapter = newsAdapter
            layoutManager = this@LatestActivity.layoutManager
            addItemDecoration(itemDecorator)
        }
    }

    private fun refreshData() {
        swpie_refresh_news.isRefreshing = true
        presenter.getCurrentData()
    }

    override fun updateRecyclerView(news: List<Item>) {
        swipeRefreshCancel()
        newsAdapter.newsList = news
        newsAdapter.notifyDataSetChanged()
    }

    override fun displayMessage(it: Throwable?) {
        super.displayMessage(it)
        swipeRefreshCancel()
    }

    private fun swipeRefreshCancel() {
        swpie_refresh_news.isRefreshing = false
    }
}
