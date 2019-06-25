package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class SpecieList(
    @SerializedName("species")
    val species: List<Specie>
)
