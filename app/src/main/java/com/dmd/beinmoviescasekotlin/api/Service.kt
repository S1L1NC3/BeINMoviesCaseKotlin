package com.dmd.beinmoviescasekotlin.api

import com.dmd.beinmoviescasekotlin.model.GenresResponse
import com.dmd.beinmoviescasekotlin.model.MoviesResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private val dest = "https://api.themoviedb.org/3/"
    //Lint sorgusu sonrası syntax içermeyen bir ad olarak değiştirildi

    //Retrofit için gerekli build işleminin yapılıp API interface'i üzerinden oluşturulduğu kod
    private val api = Retrofit.Builder()
        .baseUrl(dest)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

    //Oluşturulan obje üzerinden çekilen .getMovies method'unun parametreleriyle çağrıldığı method
    fun getDataGenres() : Single<GenresResponse> {
        return api.getGenres(language = "en-US",
            apiKey = "3bb3e67969473d0cb4a48a0dd61af747")
    }

    //Oluşturulan obje üzerinden çekilen .getMovies method'unun parametreleriyle çağrıldığı method
    fun getDataMovies() : Single<MoviesResponse>{
        return api.getMovies(withGenres = 28,
            sortBy = "popularity.desc",
            includeAdult = false ,
            includeVideo = false,
            apiKey = "3bb3e67969473d0cb4a48a0dd61af747")
    }
}