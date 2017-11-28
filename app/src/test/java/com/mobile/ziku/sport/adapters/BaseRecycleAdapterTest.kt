package com.mobile.ziku.sport.adapters

import com.mobile.ziku.sport.enums.BackgroundView
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class BaseRecycleAdapterTest {

    lateinit var scoresRecyclerAdapter : ScoresRecyclerAdapter

    @Before
    fun initAdapter(){
        scoresRecyclerAdapter = ScoresRecyclerAdapter()
    }

    @Test
    fun getBackgroundView() {
        assertEquals(BackgroundView.WHITE,scoresRecyclerAdapter.getBackgroundView(0))
        assertEquals(BackgroundView.GREY,scoresRecyclerAdapter.getBackgroundView(1))
        assertEquals(BackgroundView.WHITE,scoresRecyclerAdapter.getBackgroundView(2))
        assertEquals(BackgroundView.GREY,scoresRecyclerAdapter.getBackgroundView(3))
    }

}