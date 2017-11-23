package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView

interface ScoresContractor {

    interface View: BaseView

    interface Presenter: BasePresenter<View> {

    }

}