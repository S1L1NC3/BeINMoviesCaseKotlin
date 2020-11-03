package com.dmd.beinmoviescasekotlin.viewHolders

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.R
import com.dmd.beinmoviescasekotlin.model.Genres

class GenresViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_genres, parent, false)) {
    private var mGenreHeader: TextView? = null
    //private var mImageView: ImageView? = null

    init {
        mGenreHeader = itemView.findViewById(R.id.itemGenreHeader)
    }

    fun bind(genres: Genres) {
        mGenreHeader?.text = genres.name

        itemView.setOnClickListener {
            Log.i("BINDTHATITEM", "bind:  ${genres.id} ${genres.name}")
        }
        //Picasso.get().load(news.imageUrl).into(mImageView)
    }

}