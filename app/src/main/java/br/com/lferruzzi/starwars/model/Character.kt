package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class Character(
    @SerializedName("name")
    val name: String,
    @SerializedName("birth_year")
    val birthYear: String,
    @SerializedName("species")
    val specieUrls: List<String>,
    @SerializedName("films")
    val filmUrls: List<String>,
    @SerializedName("url")
    val url: String
)
