package com.example.a65appstest.di

import android.app.Application
import androidx.room.Room
import com.example.a65appstest.repositories.local.database.LocalBase
import com.example.a65appstest.repositories.remote.API
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideDatabase(app: Application): LocalBase =
        Room.databaseBuilder(app, LocalBase::class.java, "Database")
            .allowMainThreadQueries()
            .build()

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder()
            .baseUrl(API.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(getGson()))
            .build()

    @Provides
    @Singleton
    fun provideAPI(retrofit: Retrofit) : API =
        retrofit.create(API::class.java)

    private fun getGson(): Gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
}