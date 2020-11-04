package com.dmd.beinmoviescasekotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.beinmoviescasekotlin.api.Service
import io.reactivex.disposables.CompositeDisposable

open class MainViewModel : ViewModel() {
    /*Tekrar tekrar aynı değişkenler instance alınmasın diye kendi ViewModel class'ımı yazdım. Bu şekilde,
    * Service'den türeyen dataApiService'i tekrar tekrar yazmayıp DRY ( Don't Repeat Yourself ) felsefesine
    * uygun kod yazmış oluyorum*/

    protected val dataApiService = Service()
    protected val disposable = CompositeDisposable()

    val data = MutableLiveData<List<Any>>() //Any yaparak aslında generic mantığına uygun yaptım
    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    //override edilebilmesi için open olarak tanımladım
    open fun refreshData(){}
}