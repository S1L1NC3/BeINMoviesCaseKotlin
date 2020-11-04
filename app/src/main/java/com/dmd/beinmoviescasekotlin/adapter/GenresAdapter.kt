package com.dmd.beinmoviescasekotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.dmd.beinmoviescasekotlin.model.Genres
import com.dmd.beinmoviescasekotlin.viewHolders.GenresViewHolder

class GenresAdapter(private val genresList: ArrayList<Genres>): RecyclerView.Adapter<GenresViewHolder>() {

    /*ViewHolder oluştuğu anda GenresViewHolder'a inflater'ı parametre olarak gönderip
    *constructor'dan dönen instance'ı aldığı an
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenresViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return GenresViewHolder(inflater, parent)
    }

    /*holder (GenresViewHolder)'ın içindeki bind methoduna genresList'in gerekli pozisyonundaki
    * objeyi pass ettiğimiz ve atama işleminin gerçekleşmesini sağladığımız yer*/
    override fun onBindViewHolder(holder: GenresViewHolder, position: Int) {
        val genreToBind : Genres = genresList[position]
        holder.bind(genreToBind)
    }

    override fun getItemCount(): Int {
        return genresList.size //Kategorilerin size'ı kadar dönsün diye
    }

    //MutableLiveData'nın değişmesi durumunda callback olarak verinin değişiceğini söylediğimiz nokta
    fun updateGenresList(newGenresList: List<Genres>){
        genresList.clear()
        genresList.addAll(newGenresList)
        notifyDataSetChanged()
    }
}