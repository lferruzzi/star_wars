package br.com.lferruzzi.starwars.rest

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class StarWarsWebClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl(CHARACTER_SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun characterEndpoint(): CharacterEndpointInterface = retrofit.create(CharacterEndpointInterface::class.java)

    fun filmEndpoint(): FilmEndpointInterface = retrofit.create(FilmEndpointInterface::class.java)

    companion object {
        private const val CHARACTER_SERVER_URL = "https://swapi.co/api/"
    }
}
