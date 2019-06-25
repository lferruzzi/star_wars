package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class CharacterList(
    @SerializedName("results")
    val characters: List<Character>
)
