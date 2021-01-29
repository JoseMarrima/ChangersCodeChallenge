package com.example.changerscodechallenge.data

import com.example.changerscodechallenge.model.BreedResponse
import com.example.changerscodechallenge.model.DogsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface DogService {

    @GET("v1/breeds/")
    suspend fun getAllBreeds(
        @Query("x-api-key") apiKey: String,
        @Query("limit") limit: Int
    ): BreedResponse

    @GET("v1/images/search")
    suspend fun getDogsByBreed(
        @Query("x-api-key") apiKey: String,
        @Query("bread_ids") breedIds: String
    ): DogsResponse
}