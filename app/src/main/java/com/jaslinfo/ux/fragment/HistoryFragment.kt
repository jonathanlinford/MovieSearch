package com.jaslinfo.ux.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaslinfo.ux.DataSingleton
import com.jaslinfo.ux.MovieAdapter

import com.jaslinfo.ux.R
import kotlinx.android.synthetic.main.fragment_history.*


class HistoryFragment : Fragment() {

    val data = DataSingleton.instance

    companion object {
        @JvmStatic
        fun newInstance() =
                HistoryFragment().apply {
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

        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (data.user.pendingMovies.size > 1) {
            pendingRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.HORIZONTAL
                }
                adapter = MovieAdapter(data.user.pendingMovies, context)
            }
            pendingRecyclerView.visibility = View.VISIBLE
            emptyPendingText.visibility = View.GONE
        } else {
            pendingRecyclerView.visibility = View.GONE
            emptyPendingText.visibility = View.VISIBLE
        }

        if (data.user.currentMovies.size > 1) {
            currentRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.HORIZONTAL
                }
                adapter = MovieAdapter(data.user.currentMovies, context)
            }
            currentRecyclerView.visibility = View.VISIBLE
            emptyCurrentText.visibility = View.GONE
        } else {
            currentRecyclerView.visibility = View.GONE
            emptyCurrentText.visibility = View.VISIBLE
        }

        if (data.user.pastMovies.size > 1) {
            pastRecyclerView.apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context).apply {
                    orientation = LinearLayoutManager.HORIZONTAL
                }
                adapter = MovieAdapter(data.user.pastMovies, context)
            }
            pastRecyclerView.visibility = View.VISIBLE
            emptyPastText.visibility = View.GONE
        } else {
            pastRecyclerView.visibility = View.GONE
            emptyPastText.visibility = View.VISIBLE
        }
    }
}
