package com.dmd.beinmoviescasekotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.beinmoviescasekotlin.api.Service
import com.dmd.beinmoviescasekotlin.model.Movie
import com.dmd.beinmoviescasekotlin.model.MoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MoviesViewModel : ViewModel() {
    private val dataApiService = Service()
    private val disposable = CompositeDisposable()

    val movies = MutableLiveData<List<Movie>>()
    val moviesError = MutableLiveData<Boolean>()
    val moviesLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        getDataFromApiForMovies()
    }

    private fun getDataFromApiForMovies(){
        moviesLoading.value= true

        disposable.add(
            dataApiService.getDataMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MoviesResponse>(){
                    override fun onSuccess(t: MoviesResponse) {
                        movies.value = t.results
                        moviesError.value=false
                        moviesLoading.value=false

                    }

                    override fun onError(e: Throwable) {
                        moviesLoading.value=false
                        moviesError.value=true
                        e.printStackTrace()

                    }

                })
        )
    }

}