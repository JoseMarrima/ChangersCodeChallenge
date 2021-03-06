package com.example.changerscodechallenge.model


import com.google.gson.annotations.SerializedName

data class DogsItem(
    @SerializedName("breeds")
    val breeds: List<Breed>?,
    @SerializedName("height")
    val height: Int?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("url")
    val url: String?,
    @SerializedName("width")
    val width: Int?
)