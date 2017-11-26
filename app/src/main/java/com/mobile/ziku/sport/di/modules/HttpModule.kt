package com.mobile.ziku.sport.di.modules

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.mobile.ziku.sport.http.RetrofitService
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
class HttpModule {
    companion object {
        const val TIMEOUT = 10L
        const val RETROFIT_URL = "retrofitUrl"
    }

    @Provides
    @Singleton
    fun provideRetrofitService(@Named(RETROFIT_URL) retrofitUrl : String, okHttpClient: OkHttpClient) : Retrofit {
        return Retrofit.Builder()
                .baseUrl(retrofitUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(SimpleXmlConverterFactory.create() )
                .client(okHttpClient)
                .build()
    }

    @Provides
    @Singleton
    fun provideHotShotSerrvice(retrofit: Retrofit) : RetrofitService.SportService{
        return retrofit.create(RetrofitService.SportService::class.java)

    }

    @Provides
    @Singleton
    fun privideOkHttp() : OkHttpClient {
        val okHttpBuilder =  OkHttpClient.Builder()
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        okHttpBuilder.apply {
            addInterceptor(logging)
            readTimeout(TIMEOUT, TimeUnit.SECONDS)
            connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        }
        return okHttpBuilder.build()
    }

    @Provides
    @Named(RETROFIT_URL)
    fun provideRetrofitUrl():String = "http://www.mobilefeeds.performgroup.com/"

}