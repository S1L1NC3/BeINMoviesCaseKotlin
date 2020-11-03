package com.dmd.beinmoviescasekotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.beinmoviescasekotlin.api.Service
import com.dmd.beinmoviescasekotlin.model.Genres
import com.dmd.beinmoviescasekotlin.model.GenresResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GenresViewModel : ViewModel() {
    private val dataApiService = Service()
    private val disposable = CompositeDisposable()

    val genres = MutableLiveData<List<Genres>>()
    val genresError = MutableLiveData<Boolean>()
    val genresLoading = MutableLiveData<Boolean>()

    fun refreshData(){
        getDataFromApiForGenres()
    }

    private fun getDataFromApiForGenres(){
        genresLoading.value= true

        disposable.add(
            dataApiService.getDataGenres()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<GenresResponse>(){
                    override fun onSuccess(t: GenresResponse) {
                        genres.value = t.genres
                        genresError.value=false
                        genresLoading.value=false

                    }

                    override fun onError(e: Throwable) {
                        genresLoading.value=false
                        genresError.value=true
                        e.printStackTrace()

                    }

                })
        )
    }

}