package com.jaslinfo.ux.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaslinfo.ux.R
import kotlinx.android.synthetic.main.fragment_account.*


class AccountFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                AccountFragment().apply {
                    arguments = Bundle().apply {
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
        }
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        accountNavigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        accountNavigation.selectedItemId = R.id.navigation_history
    }

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_history -> {
                onHistorySelected()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_my_movies -> {
                onMoviesSelected()
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_friends -> {
                onFriendsSelected()
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun onHistorySelected() {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.accountFrame, HistoryFragment.newInstance())
                ?.commit()
    }

    private fun onMoviesSelected() {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.accountFrame, MyMoviesFragment.newInstance())
                ?.commit()
    }

    private fun onFriendsSelected() {
        activity?.supportFragmentManager
                ?.beginTransaction()
                ?.replace(R.id.accountFrame, MyMoviesFragment.newInstance())
                ?.commit()
    }
}
