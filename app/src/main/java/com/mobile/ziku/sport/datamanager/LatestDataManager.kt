package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.constractors.LatestContractor
import com.mobile.ziku.sport.http.RetrofitService
import com.mobile.ziku.sport.models.Item
import io.reactivex.Single
import javax.inject.Inject

class LatestDataManager @Inject constructor(
        val retrofitService: RetrofitService.SportService
): LatestContractor.DataManager{


    override fun downloadLastNews(): Single<List<Item>> {
        return retrofitService.getLatestNews()
                .map { it.channel?.items?.toList() ?: emptyList()}
    }
}