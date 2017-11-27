package com.mobile.ziku.sport.fragments

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import com.mobile.ziku.sport.R
import com.mobile.ziku.sport.activities.LatestActivity
import com.mobile.ziku.sport.activities.ScoresActivity
import com.mobile.ziku.sport.activities.StandingsActivity
import kotlinx.android.synthetic.main.fragment_navigation.*

class MenuFragment : Fragment() {

    var animationInProgress = false

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_navigation, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initMenuNavigation()
    }

    private fun initMenuNavigation() {
        textViewNew.setOnClickListener { goToActivity(LatestActivity::class.java) }
        textViewScores.setOnClickListener { goToActivity(ScoresActivity::class.java) }
        textViewStandings.setOnClickListener { goToActivity(StandingsActivity::class.java) }
    }

    private fun goToActivity(cls: Class<*>) {
        val intent = Intent(activity, cls)
        startActivity(intent)
    }


    override fun onCreateAnimation(transit: Int, enter: Boolean, nextAnim: Int): Animation {
        val animation = AnimationUtils.loadAnimation(activity, nextAnim)
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationEnd(animation: Animation?) {
                animationInProgress = false
            }

            override fun onAnimationStart(animation: Animation?) {
                animationInProgress = true
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        return animation
    }
}