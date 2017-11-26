package com.mobile.ziku.sport.http

import com.mobile.ziku.sport.models.BaseResponse
import io.reactivex.Single
import retrofit2.http.GET

class RetrofitService {

    interface SportService {
        @GET("utilities/interviews/techtest/latestnews.xml")
        fun getLatestNews()// : Single<>

        @GET("utilities/interviews/techtest/scores.xml")
        fun getScores() : Single<BaseResponse>

        @GET("utilities/interviews/techtest/standings.xml")
        fun getStandings() : Single<BaseResponse>
    }
}