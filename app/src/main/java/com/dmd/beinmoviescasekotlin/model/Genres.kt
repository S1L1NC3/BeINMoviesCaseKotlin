package com.dmd.beinmoviescasekotlin.model

import com.google.gson.annotations.SerializedName

//Modelleri açıklama gereği duymuyorum. Retrofit kullanırken Gson binding yaptığı için gerekli .kt sınıfları
data class Genres (
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String
)