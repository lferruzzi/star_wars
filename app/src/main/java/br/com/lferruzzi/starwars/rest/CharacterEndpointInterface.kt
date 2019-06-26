package br.com.lferruzzi.starwars.rest

import br.com.lferruzzi.starwars.model.Character
import br.com.lferruzzi.starwars.model.CharacterList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterEndpointInterface {

    @GET("people/")
    fun searchCharacterList(
        @Query("search")
        name: String
    ): Call<CharacterList>

    @GET("people/")
    fun getFullCharacterList(): Call<CharacterList>

    @GET("people/{id}")
    fun getCharacterById(
        @Path("id")
        id: String
    ): Call<Character>
}
