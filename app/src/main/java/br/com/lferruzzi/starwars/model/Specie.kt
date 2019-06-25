package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class Specie(
    @SerializedName("name")
    val name: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("homeworld")
    val homeWorld: Planet
)
