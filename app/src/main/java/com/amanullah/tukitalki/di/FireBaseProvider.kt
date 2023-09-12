package com.amanullah.tukitalki.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
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

    @Provides
    @Singleton 
    fun provideDb():FirebaseDatabase{

        return FirebaseDatabase.getInstance()


    }

}