package com.mobile.ziku.sport.di.modules.activities

import com.mobile.ziku.sport.constractors.ScoresContractor
import com.mobile.ziku.sport.datamanager.ScoresDataManager
import com.mobile.ziku.sport.di.scopes.ActivityScope
import com.mobile.ziku.sport.presenters.ScoresPresenter
import dagger.Binds
import dagger.Module

@Module
abstract class ScoresActivityModule {

    @ActivityScope
    @Binds
    abstract fun bindScoresPresenter(scoresPresenter: ScoresPresenter) : ScoresContractor.Presenter

    @ActivityScope
    @Binds
    abstract fun bindScoresDataManager(scoresDataManager: ScoresDataManager) : ScoresContractor.DataManager
}