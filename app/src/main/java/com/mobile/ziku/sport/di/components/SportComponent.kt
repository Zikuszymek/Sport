package com.mobile.ziku.sport.di.components

import com.mobile.ziku.sport.SportApplication
import com.mobile.ziku.sport.di.modules.ActivitiesModule
import com.mobile.ziku.sport.di.modules.AppModule
import com.mobile.ziku.sport.di.modules.HttpModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivitiesModule::class,
        HttpModule::class,
        AppModule::class
))
interface SportComponent : AndroidInjector<SportApplication>{

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(application: SportApplication) : SportComponent.Builder
        fun build() : SportComponent
    }
}