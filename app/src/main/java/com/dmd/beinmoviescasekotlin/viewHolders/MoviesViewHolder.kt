package com.dmd.beinmoviescasekotlin.viewHolders

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.MainActivity
import com.dmd.beinmoviescasekotlin.R
import com.dmd.beinmoviescasekotlin.model.Movie
import com.squareup.picasso.Picasso

class MoviesViewHolder(inflater: LayoutInflater, parent: ViewGroup) :
    RecyclerView.ViewHolder(inflater.inflate(R.layout.item_movies, parent, false)) {
    private var mMovieHeader: TextView? = null
    private var mMoviePoster: ImageView? = null
    //TODO: Companion object ile poster path ayarla
    //TODO: firebase entegrasyonu yap

    init {
        mMovieHeader = itemView.findViewById(R.id.txtMoviesHeader)
        mMoviePoster = itemView.findViewById(R.id.imgMoviesPoster)
    }

    fun bind(movie: Movie) {
        mMovieHeader?.text = movie.title
        Picasso.get().load(MainActivity.returnImagePath()+ movie.poster_path).into(mMoviePoster)
    }

}