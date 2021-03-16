package com.app.edson.repository

import com.app.edson.data.ApiClient
import com.app.edson.data.ApiResult
import com.app.edson.data.models.PokemonList
import java.lang.Exception
import javax.inject.Inject

interface PokemonRepository {
    suspend fun getPokes(offset: Int, limit: Int): ApiResult<PokemonList>
}

class PokemonRepositoryImpl @Inject constructor (
    private val apiClient: ApiClient
): PokemonRepository {

    override suspend fun getPokes(offset: Int, limit: Int): ApiResult<PokemonList> {
        return try {
            val pokemonList = apiClient.service.fetchPokemonList(limit, offset)
            ApiResult.success(pokemonList)
        } catch (e: Exception) {
            ApiResult.error(e)
        }
    }
}