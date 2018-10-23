package com.jaslinfo.ux

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.list_item_movie.view.*


class MovieAdapter(val items: ArrayList<Movie>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item_movie, parent, false))
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.view.imageView.setImageResource(items[position].coverDrawableId?: R.drawable.space_jam_poster)
    }
}

class ViewHolder (var view: View) : RecyclerView.ViewHolder(view)
