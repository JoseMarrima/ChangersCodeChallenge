package com.example.changerscodechallenge.model


import com.google.gson.annotations.SerializedName

data class WeightX(
    @SerializedName("imperial")
    val imperial: String?,
    @SerializedName("metric")
    val metric: String?
)