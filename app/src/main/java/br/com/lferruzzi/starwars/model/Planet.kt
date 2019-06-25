package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class Planet(
    @SerializedName("name")
    val name: String,
    @SerializedName("population")
    val population: Int
)
