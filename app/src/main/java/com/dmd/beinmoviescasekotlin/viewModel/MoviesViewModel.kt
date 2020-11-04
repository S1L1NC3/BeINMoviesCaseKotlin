package com.dmd.beinmoviescasekotlin.viewModel

import com.dmd.beinmoviescasekotlin.model.MoviesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class MoviesViewModel : MainViewModel() {
    //GenresViewModel içerisinde açıkladım tek tek burada yazmak istemedim.

    //Kendi yarattığım sınıfı override ettim
    override fun refreshData(){
        getDataFromApiForMovies()
    }

    private fun getDataFromApiForMovies(){
        loading.value= true

        disposable.add(
            dataApiService.getDataMovies()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<MoviesResponse>(){
                    override fun onSuccess(t: MoviesResponse) {
                        data.value = t.results
                        error.value=false
                        loading.value=false

                    }

                    override fun onError(e: Throwable) {
                        loading.value=false
                        error.value=true
                        e.printStackTrace()

                    }

                })
        )
    }

}