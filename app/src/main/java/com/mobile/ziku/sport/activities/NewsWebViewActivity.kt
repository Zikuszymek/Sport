package com.mobile.ziku.sport.activities

import android.os.Bundle
import android.view.MenuItem
import com.mobile.ziku.sport.R
import dagger.android.support.DaggerAppCompatActivity
import kotlinx.android.synthetic.main.activity_news_web_view.*

class NewsWebViewActivity : DaggerAppCompatActivity() {

    companion object {
        const val URL = "url"
        const val TITLE = "title"
        const val EMPTY = ""
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_web_view)
        loadWebView()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    fun loadWebView() {
        if (intent.extras != null) {
            val url = intent.extras.getString(URL, EMPTY)
            title = intent.extras.getString(TITLE, EMPTY)
            web_view.loadUrl(url)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return true
    }
}
