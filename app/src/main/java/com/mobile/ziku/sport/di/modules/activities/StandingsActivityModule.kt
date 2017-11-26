package com.mobile.ziku.sport.di.modules.activities

import com.mobile.ziku.sport.constractors.StandingsContractor
import com.mobile.ziku.sport.datamanager.StandingsDataManager
import com.mobile.ziku.sport.di.scopes.ActivityScope
import com.mobile.ziku.sport.presenters.StandingsPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class StandingsActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindStandingPresenter(standingsPresenter: StandingsPresenter) : StandingsContractor.Presenter

    @ActivityScope
    @Binds
    abstract fun bindStandingsDataManager(standingsDataManager: StandingsDataManager) : StandingsContractor.DataManager

}