package com.jaslinfo.ux.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaslinfo.ux.DataSingleton
import com.jaslinfo.ux.MovieAdapter

import com.jaslinfo.ux.R
import kotlinx.android.synthetic.main.fragment_my_movies.*


class MyMoviesFragment : Fragment() {

    val data = DataSingleton.instance

    companion object {
        @JvmStatic
        fun newInstance() =
                MyMoviesFragment().apply {
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

        return inflater.inflate(R.layout.fragment_my_movies, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (data.user.myMovies.size > 1) {
            myMoviesRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = GridLayoutManager(context, 3)
                adapter = MovieAdapter(data.user.pendingMovies, context)
            }
            myMoviesRecyclerView.visibility = View.VISIBLE
            emptyMyMoviesText.visibility = View.GONE
        } else {
            myMoviesRecyclerView.visibility = View.GONE
            emptyMyMoviesText.visibility = View.VISIBLE
        }
    }
}
