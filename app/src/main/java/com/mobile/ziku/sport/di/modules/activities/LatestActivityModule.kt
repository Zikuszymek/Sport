package com.mobile.ziku.sport.di.modules.activities

import com.mobile.ziku.sport.constractors.LatestContractor
import com.mobile.ziku.sport.datamanager.LatestDataManager
import com.mobile.ziku.sport.di.scopes.ActivityScope
import com.mobile.ziku.sport.presenters.LatestPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class LatestActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindLatestPresenter(latestPresenter: LatestPresenter) : LatestContractor.Presenter

    @ActivityScope
    @Binds
    abstract fun bindLatestDataManager(latestDataManager: LatestDataManager) : LatestContractor.DataManager
}