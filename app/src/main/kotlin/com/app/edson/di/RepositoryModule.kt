package com.app.edson.di

import com.app.edson.data.ApiClient
import com.app.edson.repository.PokemonRepository
import com.app.edson.repository.PokemonRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun providesPokemonRepository(
        apiClient: ApiClient
    ): PokemonRepository {
        return PokemonRepositoryImpl(apiClient)
    }
}