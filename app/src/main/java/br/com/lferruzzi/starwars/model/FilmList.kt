package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class FilmList(
    @SerializedName("films")
    val films: List<Film>
)
