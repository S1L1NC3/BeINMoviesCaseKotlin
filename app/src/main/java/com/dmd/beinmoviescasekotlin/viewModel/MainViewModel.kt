package com.dmd.beinmoviescasekotlin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.dmd.beinmoviescasekotlin.api.Service
import io.reactivex.disposables.CompositeDisposable

open class MainViewModel : ViewModel() {

    protected val dataApiService = Service()
    protected val disposable = CompositeDisposable()

    val data = MutableLiveData<List<Any>>() //Generic mantığında liste oluşturdum List<T>
    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    open fun refreshData(){}
}