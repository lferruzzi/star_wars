package br.com.lferruzzi.starwars.model

import com.google.gson.annotations.SerializedName

data class Film(
    @SerializedName("title")
    val title: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("opening_crawl")
    val openingCrawl: String
)
