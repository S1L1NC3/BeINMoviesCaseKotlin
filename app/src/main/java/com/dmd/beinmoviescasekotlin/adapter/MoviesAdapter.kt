package com.dmd.beinmoviescasekotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.model.Movie
import com.dmd.beinmoviescasekotlin.viewHolders.MoviesViewHolder

class MoviesAdapter(private val moviesList: ArrayList<Movie>): RecyclerView.Adapter<MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MoviesViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie: Movie = moviesList[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    fun updateMoviesList(newMoviesList: List<Movie>){
        moviesList.clear()
        moviesList.addAll(newMoviesList)
        notifyDataSetChanged()
    }
}