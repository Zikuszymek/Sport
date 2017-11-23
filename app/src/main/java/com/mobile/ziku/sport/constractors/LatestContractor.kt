package com.mobile.ziku.sport.constractors

import com.mobile.ziku.sport.BasePresenter
import com.mobile.ziku.sport.BaseView

interface LatestContractor {

    interface View:BaseView

    interface Presenter:BasePresenter<View>{

    }
}