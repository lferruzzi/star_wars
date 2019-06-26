package br.com.lferruzzi.starwars.rest

import br.com.lferruzzi.starwars.model.Film
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmEndpointInterface {

    @GET("film/{id}")
    fun getFilmById(
        @Path("id")
        id: String
    ): Call<Film>
}
