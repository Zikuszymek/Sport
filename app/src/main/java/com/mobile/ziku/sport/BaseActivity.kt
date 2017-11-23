package com.mobile.ziku.sport

import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity(){


    abstract var presenter : BasePresenter<BaseView>

    fun onResume(baseView: BaseView) {
        super.onResume()
        presenter.attachView(baseView)
    }

    override fun onPause() {
        super.onPause()
        presenter.removeView()
    }
}