package com.example.workapp.navigation

import androidx.navigation.NavController
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NavModule {

    @Provides
    @Singleton
    fun provideNavComponent():NavActions {
        return NavActions()
    }
}