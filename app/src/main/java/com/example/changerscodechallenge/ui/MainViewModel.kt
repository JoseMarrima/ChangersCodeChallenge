package com.example.changerscodechallenge.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.changerscodechallenge.repository.DogRepository
import kotlinx.coroutines.Dispatchers

class MainViewModel constructor(private val repository: DogRepository) : ViewModel() {

    fun getBreeds() = liveData(Dispatchers.IO) {
        emit(repository.getBreeds())
    }

    fun searchDogByBreed(breedId: String) = liveData(Dispatchers.IO) {
        emit(repository.searchDogByBreed(breedId))
    }
}