package com.dmd.beinmoviescasekotlin.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.R
import com.dmd.beinmoviescasekotlin.model.Movie

class MoviesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movies, parent, false)) {
    private var mMovieHeader: TextView? = null
    //private var mImageView: ImageView? = null

    init {
        mMovieHeader = itemView.findViewById(R.id.txtMoviesHeader)
    }

    fun bind(movie: Movie) {
        mMovieHeader?.text = movie.title
        //Picasso.get().load(news.imageUrl).into(mImageView)
    }

}