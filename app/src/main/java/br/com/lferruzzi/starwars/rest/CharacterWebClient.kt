package br.com.lferruzzi.starwars.rest

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit

class CharacterWebClient {

    private val retrofit = Retrofit.Builder()
        .baseUrl(CHARACTER_SERVER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun characterListEndpoint(): CharacterListEndpointInterface =
        retrofit.create(CharacterListEndpointInterface::class.java)

    companion object {
        private const val CHARACTER_SERVER_URL = "https://swapi.co/api/"
    }
}
