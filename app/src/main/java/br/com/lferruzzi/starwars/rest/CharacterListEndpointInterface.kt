package br.com.lferruzzi.starwars.rest

import br.com.lferruzzi.starwars.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharacterListEndpointInterface {

    @GET("people/")
    fun searchCharacterList(
        @Query("search")
        name: String
    ): Call<CharacterList>
}
