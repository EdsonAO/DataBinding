package com.app.edson.data

import com.app.edson.data.models.PokemonList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET(Endpoint.pokemon)
    suspend fun fetchPokemonList(
        @Query(Parameter.limit) limit: Int,
        @Query(Parameter.offset) offset: Int
    ): PokemonList
}