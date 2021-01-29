package com.example.changerscodechallenge

import com.example.changerscodechallenge.data.DogService
import com.example.changerscodechallenge.repository.DefaultDogRepository
import com.example.changerscodechallenge.util.BASE_URL
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceLocator {

    @Volatile
    private var repository: DefaultDogRepository? = null


    fun getRepository() : DefaultDogRepository {
        synchronized(this) {
            return repository ?: createRepository()
        }
    }

    private fun createRepository(): DefaultDogRepository {
        val newRepo = DefaultDogRepository(service())
        repository = newRepo
        return newRepo
    }

    private fun service(): DogService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .baseUrl(BASE_URL)
            .build()
            .create(DogService::class.java)
    }
}