package com.amanullah.tukitalki.di

import com.amanullah.tukitalki.services.AuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FireBaseProvider {

    @Provides
    @Singleton
    fun provideAuth():FirebaseAuth{

        return FirebaseAuth.getInstance()


    }

}