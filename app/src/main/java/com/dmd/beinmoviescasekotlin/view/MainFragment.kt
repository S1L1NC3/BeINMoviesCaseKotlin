package com.dmd.beinmoviescasekotlin.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dmd.beinmoviescasekotlin.R
import com.dmd.beinmoviescasekotlin.adapter.GenresAdapter
import com.dmd.beinmoviescasekotlin.adapter.MoviesAdapter
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

        moviesRecylerView.layoutManager = LinearLayoutManager(activity!!.applicationContext)
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


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    /*MVVM standartlarına göre live data'yı Genres için izleniceği kısım*/
    private fun observeLiveDataForGenres(){
        genresViewModel.genres.observe(this, Observer { data ->
            data?.let {
                moviesRecylerView.visibility = View.VISIBLE
                genresAdapter.updateGenresList(data)
            }
        })
        genresViewModel.genresError.observe(this, Observer { error ->
            error?.let {

            }
        })

        genresViewModel.genresLoading.observe(this, Observer { loading ->
            loading?.let {

            }
        })
    }

    /*Movies ve Genresi ayırdığım kısım çünkü kod debug edilip incelenirken kod parçacığını incelemenin
    * daha mantıklı olucağını ve zamandan tasarruf ediliceğini düşündüm*/
    private fun observeLiveDataForMovies(){
        moviesViewModel.movies.observe(this, Observer { data ->
            data?.let {
                moviesRecylerView.visibility = View.VISIBLE
                moviesAdapter.updateMoviesList(data)
            }
        })
        moviesViewModel.moviesError.observe(this, Observer { error ->
            error?.let {

            }
        })

        moviesViewModel.moviesLoading.observe(this, Observer { loading ->
            loading?.let {

            }
        })

    }
}