package com.mobile.ziku.sport

import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mobile.ziku.sport.fragments.MenuFragment
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {

    @Inject lateinit var layoutManager: LinearLayoutManager

    var navigationIcon: MenuItem? = null

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        navigationIcon = menu?.findItem(R.id.navigation)
        return true
    }

    private val fragment by lazy { supportFragmentManager.findFragmentById(R.id.navigation_fragment) }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.navigation -> {
                if (!(fragment as MenuFragment).animationInProgress) {
                    hideOrShowFragment()
                }
            }
        }
        return true
    }

    private fun hideOrShowFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up)
        if (fragment.isHidden) {
            transaction.show(fragment)
            colorMenuIcon()
        } else {
            transaction.hide(fragment)
            normalMenuIcon()
        }
        transaction.commit()
    }

    private fun hideMenuFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up)
        if (!fragment.isHidden) {
            transaction.hide(fragment)
            normalMenuIcon()
        }
        transaction.commit()
    }

    private fun colorMenuIcon() {
        navigationIcon?.icon = resources.getDrawable(R.drawable.ic_arrow_drop_up)
    }

    private fun normalMenuIcon() {
        navigationIcon?.icon = resources.getDrawable(R.drawable.ic_arrow_down)
    }

    override fun onPause() {
        super.onPause()
        hideMenuFragment()
    }

    override fun onResume() {
        super.onResume()
        hideMenuFragment()
    }

    override fun displayMessage(it: Throwable?) {
        Toast.makeText(this, getString(R.string.donwload_data_error), Toast.LENGTH_LONG).show()
    }
}