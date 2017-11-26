package com.mobile.ziku.sport

import com.mobile.ziku.sport.di.components.DaggerSportComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class SportApplication : DaggerApplication(){

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val sportComponent = DaggerSportComponent.builder()
                .application(this)
                .build()
        sportComponent.inject(this)
        return sportComponent
    }

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}