package com.dmd.beinmoviescasekotlin.model

import com.google.gson.annotations.SerializedName

data class GenresResponse (

    @SerializedName("genres") val genres : List<Genres>
)