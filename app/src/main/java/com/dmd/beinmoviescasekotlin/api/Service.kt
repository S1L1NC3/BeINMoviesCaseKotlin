package com.dmd.beinmoviescasekotlin.api

import com.dmd.beinmoviescasekotlin.model.GenresResponse
import com.dmd.beinmoviescasekotlin.model.MoviesResponse
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class Service {
    private val BASE_URL = "https://api.themoviedb.org/3/"

    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()
        .create(API::class.java)

    fun getDataGenres() : Single<GenresResponse> {
        return api.getGenres(language = "en-US",
            apiKey = "3bb3e67969473d0cb4a48a0dd61af747")
    }

    fun getDataMovies() : Single<MoviesResponse>{
        return api.getMovies(withGenres = 28,
            sortBy = "popularity.desc",
            includeAdult = false ,
            includeVideo = false,
            apiKey = "3bb3e67969473d0cb4a48a0dd61af747")
    }
}