package com.mobile.ziku.sport

interface BasePresenter<in BaseView> {

    fun attachView(view : BaseView)
    fun removeView()
}