package com.mobile.ziku.sport

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.mobile.ziku.sport.di.components.DaggerSportComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import timber.log.Timber

class SportApplication : DaggerApplication() {

    companion object {
        @JvmStatic
        @BindingAdapter("app:srcCompat")
        fun setImageUrl(view: ImageView, url: String) {
            Glide.with(view.getContext()).load(url).into(view)
        }
    }

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