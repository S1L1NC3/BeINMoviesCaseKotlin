package com.dmd.beinmoviescasekotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmd.beinmoviescasekotlin.R
import com.dmd.beinmoviescasekotlin.adapter.GenresAdapter
import com.dmd.beinmoviescasekotlin.adapter.MoviesAdapter
import com.dmd.beinmoviescasekotlin.model.Genres
import com.dmd.beinmoviescasekotlin.model.Movie
import com.dmd.beinmoviescasekotlin.viewModel.GenresViewModel
import com.dmd.beinmoviescasekotlin.viewModel.MoviesViewModel
import kotlinx.android.synthetic.main.main_fragment.*


class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var genresViewModel: GenresViewModel
    private lateinit var moviesViewModel: MoviesViewModel
    private val genresAdapter = GenresAdapter(arrayListOf())
    private val moviesAdapter = MoviesAdapter(arrayListOf())


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        moviesViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(MoviesViewModel::class.java)
        moviesViewModel.refreshData()

        moviesRecylerView.layoutManager = GridLayoutManager(activity!!.applicationContext,2)
        moviesRecylerView.adapter = moviesAdapter







        genresViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())
            .get(GenresViewModel::class.java)
        genresViewModel.refreshData()

        genresRecyclerView.layoutManager = LinearLayoutManager(activity!!.applicationContext, LinearLayoutManager.HORIZONTAL ,false)
        genresRecyclerView.adapter = genresAdapter

        observeLiveDataForGenres()
        observeLiveDataForMovies()

        super.onViewCreated(view, savedInstanceState)
    }

    /*MVVM standartlarına göre live data'yı Genres için izleniceği kısım*/
    private fun observeLiveDataForGenres(){
        genresViewModel.data.observe(this, Observer { data ->
            data?.let {
                genresRecyclerView.visibility = View.VISIBLE
                genresAdapter.updateGenresList(data as List<Genres>)
            }
        })
        genresViewModel.error.observe(this, Observer { error ->
            error?.let {
                print("deneme")
            }
        })

        genresViewModel.loading.observe(this, Observer { loading ->
            loading?.let {
                print("deneme")
            }
        })
    }

    /*Movies ve Genresi ayırdığım kısım çünkü kod debug edilip incelenirken kod parçacığını incelemenin
    * daha mantıklı olucağını ve zamandan tasarruf ediliceğini düşündüm*/
    private fun observeLiveDataForMovies(){
        moviesViewModel.data.observe(this, Observer { data ->
            data?.let {
                moviesRecylerView.visibility = View.VISIBLE
                moviesAdapter.updateMoviesList(data as List<Movie>)
            }
        })
        moviesViewModel.error.observe(this, Observer { error ->
            error?.let {

            }
        })

        moviesViewModel.loading.observe(this, Observer { loading ->
            loading?.let {

            }
        })

    }

    override fun onStart() {

        //SwipeRefreshLayout mantığında yaptım böylece daha güncel gesture'lara yakın bir uygulama olucak
        swipeRefreshLayout.setOnRefreshListener {
            genresRecyclerView.visibility=View.GONE
            moviesRecylerView.visibility=View.GONE
            genresViewModel.refreshData()
            moviesViewModel.refreshData()
            swipeRefreshLayout.isRefreshing=false
        }

        super.onStart()
    }
}