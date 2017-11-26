package com.mobile.ziku.sport

import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.mobile.ziku.sport.fragments.MenuFragment
import dagger.android.support.DaggerAppCompatActivity
import timber.log.Timber

abstract class BaseActivity : DaggerAppCompatActivity(), BaseView {

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    private val fragment by lazy { supportFragmentManager.findFragmentById(R.id.navigation_fragment) }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (!(fragment as MenuFragment).animationInProgress) {
            hideOrShowFragment()
        }
        return true
    }

    private fun hideOrShowFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up)
        if (fragment.isHidden) {
            transaction.show(fragment)
        } else {
            transaction.hide(fragment)
        }
        transaction.commit()
    }

    private fun hideMenuFragment() {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.setCustomAnimations(R.anim.slide_down, R.anim.slide_up)
        if (!fragment.isHidden) {
            transaction.hide(fragment)
        }
        transaction.commit()
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