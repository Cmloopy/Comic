package com.cmloopy.comic.models
import com.google.gson.annotations.SerializedName

data class Category (
    @SerializedName("idCategory") val idCategory: Int,
    @SerializedName("nameCategory") val nameCategory: String
)