package com.mobile.ziku.sport.http

import retrofit2.http.GET

class RetrofitService {

    interface SportService {
        @GET("latestnews.xml")
        @GET("cores.xml")
        @GET("standings.xml")
    }
}