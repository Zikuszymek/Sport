package com.mobile.ziku.sport.adapters

import android.support.v7.widget.RecyclerView
import com.mobile.ziku.sport.enums.BackgroundView

abstract class BaseRecycleAdapter<T : RecyclerView.ViewHolder, I : Any> : RecyclerView.Adapter<T>() {

    fun getBackgroundView(position: Int): BackgroundView {
        return when (position % 2) {
            0 -> BackgroundView.WHITE
            1 -> BackgroundView.GREY
            else -> BackgroundView.WHITE
        }
    }

    abstract fun updateList(newList: List<I>)

}