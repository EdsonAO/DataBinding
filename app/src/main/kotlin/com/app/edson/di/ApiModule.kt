package com.app.edson.di

import com.app.edson.data.ApiClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import javax.inject.Singleton

@Module
@InstallIn(ActivityComponent::class)
object ApiModule {

    @Provides
    @Singleton
    fun providesApiClient(): ApiClient {
        return ApiClient()
    }
}