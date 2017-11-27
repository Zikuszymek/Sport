package com.mobile.ziku.sport.di.modules

import com.mobile.ziku.sport.activities.LatestActivity
import com.mobile.ziku.sport.activities.NewsWebViewActivity
import com.mobile.ziku.sport.activities.ScoresActivity
import com.mobile.ziku.sport.activities.StandingsActivity
import com.mobile.ziku.sport.di.modules.activities.LatestActivityModule
import com.mobile.ziku.sport.di.modules.activities.ScoresActivityModule
import com.mobile.ziku.sport.di.modules.activities.StandingsActivityModule
import com.mobile.ziku.sport.di.scopes.ActivityScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(LatestActivityModule::class))
    abstract fun provideLatestActivity(): LatestActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ScoresActivityModule::class))
    abstract fun provideScoresActivity(): ScoresActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(StandingsActivityModule::class))
    abstract fun provideStandingsActivity(): StandingsActivity

    @ActivityScope
    @ContributesAndroidInjector()
    abstract fun provideNewsWebViewActivity(): NewsWebViewActivity
}