package com.dmd.beinmoviescasekotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.model.Genres
import com.dmd.beinmoviescasekotlin.viewHolders.GenresViewHolder

class GenresAdapter(private val genresList: ArrayList<Genres>): RecyclerView.Adapter<GenresViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GenresViewHolder(inflater, parent)
    }

    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genreToBind : Genres = genresList[position]
        holder.bind(genreToBind)
    }

    override fun getItemCount(): Int {
        return genresList.size
    }

    fun updateGenresList(newGenresList: List<Genres>){
        genresList.clear()
        genresList.addAll(newGenresList)
        notifyDataSetChanged()
    }
}