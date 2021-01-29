package com.example.changerscodechallenge.repository

import com.example.changerscodechallenge.data.DogService
import com.example.changerscodechallenge.model.BreedsItem
import com.example.changerscodechallenge.model.DogsItem
import com.example.changerscodechallenge.util.API_KEY
import com.example.changerscodechallenge.util.LIMIT

class DefaultDogRepository(private val dogService: DogService) : DogRepository {

    override suspend fun searchDogByBreed(breedId: String): List<DogsItem> {
        return dogService.getDogsByBreed(API_KEY, breedId)
    }

    override suspend fun getBreeds(): List<BreedsItem> {
        return dogService.getAllBreeds(API_KEY, LIMIT)
    }
}