package com.app.edson.ui.home

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.app.edson.data.ApiClient
import com.app.edson.data.ApiResult
import com.app.edson.repository.PokemonRepository
import com.app.edson.repository.PokemonRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    app: Application,
    private val pokemonRepository: PokemonRepositoryImpl
) : AndroidViewModel(app) {

    fun init() {
        viewModelScope.launch {
            when (val remoteCall = pokemonRepository.getPokes(limit = 20, offset = 0)) {
                is ApiResult.Success -> {
                    remoteCall.data.results.forEach {
                        Log.i(TAG, "name: ${it.name}, url: ${it.url}")
                    }
                }
                is ApiResult.Error -> {
                    Log.e(TAG, "Message: ${remoteCall.exception.message}")
                }
            }
        }
    }

    companion object {
        private val TAG = HomeViewModel::class.java.simpleName
    }
}