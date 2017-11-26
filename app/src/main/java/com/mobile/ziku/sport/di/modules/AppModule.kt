package com.mobile.ziku.sport.di.modules

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import com.mobile.ziku.sport.SportApplication
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun provideContext(application: SportApplication): Context = application.applicationContext

    @Provides
    fun provideDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
}