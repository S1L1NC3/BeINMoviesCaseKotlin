package com.dmd.beinmoviescasekotlin.viewModel

import com.dmd.beinmoviescasekotlin.model.GenresResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class GenresViewModel : MainViewModel() {
    //Fragment içerisinde api call'un yapılması sağlıklı olmadığından viewModel içerisinde yaptım

    //İki viewModel'imi de  kendi oluşturduğum viewModel'den türettim
    override fun refreshData(){
        getDataFromApiForGenres()
    }

    private fun getDataFromApiForGenres(){
        loading.value= true

        disposable.add(
            dataApiService.getDataGenres()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<GenresResponse>(){
                    override fun onSuccess(t: GenresResponse) {
                        data.value = t.genres
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