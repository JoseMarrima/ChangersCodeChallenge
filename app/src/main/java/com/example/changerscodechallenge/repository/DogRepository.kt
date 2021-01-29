package com.example.changerscodechallenge.repository

import com.example.changerscodechallenge.model.BreedsItem
import com.example.changerscodechallenge.model.DogsItem

interface DogRepository {
    suspend fun searchDogByBreed(breedId: String) : List<DogsItem>
    suspend fun getBreeds() : List<BreedsItem>
}
