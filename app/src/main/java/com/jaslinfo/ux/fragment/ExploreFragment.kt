package com.jaslinfo.ux.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.jaslinfo.ux.R
import android.widget.ImageView
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.os.AsyncTask
import com.jaslinfo.ux.Movie

class ExploreFragment : Fragment() {
    companion object {
        fun newInstance(param1: String, param2: String) =
                ExploreFragment().apply {
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
        val view = inflater.inflate(R.layout.fragment_explore, container, false)

        val nearMe = arrayListOf(Movie().apply{
            id = 0
            title = "zero"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 1
            title = "one"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 2
            title = "two"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 3
            title = "three"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 4
            title = "four"
            coverDrawableId = R.drawable.space_jam_poster
        }, Movie().apply{
            id = 5
            title = "five"
            coverDrawableId = R.drawable.space_jam_poster
        })

//        view.recycler1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        view.recycler1.adapter = CoverAdapter(nearMe)
//        view.recycler2.adapter = CoverAdapter(nearMe)
//        view.recycler3.adapter = CoverAdapter(nearMe)

        return view
    }

    interface OnExploreFragmentInteractionListener {
//        fun onFragmentInteraction(uri: Uri)
    }


        private inner class DownloadImageTask(internal var bmImage: ImageView) : AsyncTask<String, Void, Bitmap>() {

            override fun doInBackground(vararg urls: String): Bitmap? {
                val urldisplay = urls[0]
                var mIcon11: Bitmap? = null
                try {
                    val `in` = java.net.URL(urldisplay).openStream()
                    mIcon11 = BitmapFactory.decodeStream(`in`)
                } catch (e: Exception) {
                    e.printStackTrace()
                }

                return mIcon11
            }

            override fun onPostExecute(result: Bitmap) {
                bmImage.setImageBitmap(result)
            }
        }

}
