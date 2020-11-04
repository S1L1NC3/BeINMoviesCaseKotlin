package com.dmd.beinmoviescasekotlin.api

import com.dmd.beinmoviescasekotlin.model.GenresResponse
import com.dmd.beinmoviescasekotlin.model.MoviesResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface API {

    /*Retrofit için oluşturduğumuz API katmanı, gitmemiz gerekli olan method'ların gerekli parametrelerini
    * vermeyi tercih ettim*/

    @GET("genre/movie/list")
    fun getGenres(@Query("api_key") apiKey: Any,
                  @Query("language") language: Any) : Single<GenresResponse>


    /*Sonuç olarak bize Gson'la  SerializedName kullanılarak objeleştirilmesini sağlamış bir
    Single<T> dönücek */
    @GET("discover/movie")
    fun getMovies(@Query("api_key") apiKey: Any,
                  @Query("sort_by") sortBy: Any,
                  @Query("include_adult") includeAdult: Boolean,
                  @Query("include_video") includeVideo: Boolean,
                  @Query("with_genres") withGenres : Any) : Single<MoviesResponse>
}