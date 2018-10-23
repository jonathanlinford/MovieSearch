package com.jaslinfo.ux.activity

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.support.v7.app.AppCompatActivity
import com.jaslinfo.ux.DataSingleton
import com.jaslinfo.ux.R
import com.jaslinfo.ux.fragment.AccountFragment
import com.jaslinfo.ux.fragment.ExploreFragment
import com.jaslinfo.ux.fragment.SearchFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ExploreFragment.OnExploreFragmentInteractionListener, SearchFragment.OnSearchFragmentInteractionListener {

    private var currentState: TabState = TabState.EXPLORE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        navigation.selectedItemId = R.id.navigation_explore

        supportFragmentManager
                .beginTransaction()
                .add(R.id.frame, ExploreFragment.newInstance("str1", "str2"))
                .commit()

        DataSingleton.instance.initTest(DataSingleton.instance)
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_explore -> {
                onExploreSelected()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search -> {
                onSearchSelected()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_account -> {
                onAccountSelected()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun onExploreSelected() {
        if (currentState != TabState.EXPLORE) {
            currentState = TabState.EXPLORE
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, ExploreFragment.newInstance("str1", "str2"))
                    .commit()
        }
    }

    private fun onSearchSelected() {
        if (currentState != TabState.SEARCH) {
            currentState = TabState.SEARCH
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, SearchFragment.newInstance("str1", "str2"))
                    .commit()
        }
    }

    private fun onAccountSelected() {
        if (currentState != TabState.ACCOUNT) {
            currentState = TabState.ACCOUNT
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.frame, AccountFragment.newInstance("str1", "str2"))
                    .commit()
        }
    }

    enum class TabState {
        EXPLORE,
        SEARCH,
        ACCOUNT
    }
}
