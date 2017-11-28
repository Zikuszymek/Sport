package com.mobile.ziku.sport.datamanager

import com.mobile.ziku.sport.TestFactory
import com.mobile.ziku.sport.constractors.StandingsContractor
import com.mobile.ziku.sport.http.RetrofitService
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mockito


class StandingsDataManagerTest {

    lateinit var retrofitService: RetrofitService.SportService
    lateinit var scoresDataManager: StandingsContractor.DataManager

    @Before
    fun setup() {
        retrofitService = Mockito.mock(RetrofitService.SportService::class.java)
        scoresDataManager = StandingsDataManager(retrofitService)
        Mockito.`when`(retrofitService.getStandings()).thenReturn(TestFactory.getSingleStandings())
    }

    @Test
    fun downloadCurrentStandings() {
        val standingsList = scoresDataManager.downloadCurrentStandings().blockingGet()
        assertEquals(TestFactory.ONE, standingsList[0].rank)
        assertEquals(TestFactory.TWO, standingsList[1].rank)
        assertEquals(TestFactory.THREE, standingsList[2].rank)
    }

}