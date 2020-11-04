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

    init {
        /*Constructor içinde res > layout > item_genres içerisindeki .xml'den  türetildikten sonra
        * içerisindeki componentlere erişim ve yerel private componentleri eşitmelek için, bind methodunda
        * bunlara veri atanıcak*/
        mGenreHeader = itemView.findViewById(R.id.itemGenreHeader)
    }

    /* view holder'ın bind methodu çağrıldığında gelen objenin constructor içinde find'lanmış olan
    * yerel değişkenin .text gibi özelliklerine erişim & değerine müdahele*/
    fun bind(genres: Genres) {
        mGenreHeader?.text = genres.name

        itemView.setOnClickListener {
            Log.i("BINDTHATITEM", "bind:  ${genres.id} ${genres.name}")
        }
    }

}