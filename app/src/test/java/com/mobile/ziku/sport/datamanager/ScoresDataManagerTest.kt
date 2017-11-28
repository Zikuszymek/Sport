package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.TestFactory
import com.mobile.ziku.sport.TestFactory.MATCHES_COUNT
import com.mobile.ziku.sport.constractors.ScoresContractor
import com.mobile.ziku.sport.http.RetrofitService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class ScoresDataManagerTest {

    lateinit var retrofitService: RetrofitService.SportService
    lateinit var scoresDataManager: ScoresContractor.DataManager

    @Before
    fun setup() {
        retrofitService = mock(RetrofitService.SportService::class.java)
        scoresDataManager = ScoresDataManager(retrofitService)
        `when`(retrofitService.getScores()).thenReturn(TestFactory.getSingleScores())
    }

    @Test
    fun downloadCurrentScores() {
        val scoresViewUpdate = scoresDataManager.downloadCurrentScores().blockingGet()
        assertEquals(TestFactory.DATE, scoresViewUpdate.header)
        assertEquals(MATCHES_COUNT, scoresViewUpdate.scores.size)
    }

}