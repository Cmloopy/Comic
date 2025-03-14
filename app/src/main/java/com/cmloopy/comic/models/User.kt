package com.cmloopy.comic.models

import com.google.gson.annotations.SerializedName

data class User (
    @SerializedName("idUser") val idUser: Int,
    @SerializedName("nameUser") val nameUser: String,
    @SerializedName("username") val username: String,
    @SerializedName("pass") val pass: String,
    @SerializedName("email") val email: String,
    @SerializedName("phone") val phone: String,
    @SerializedName("count") val count: Int,
    @SerializedName("roll") val roll: Int,
    @SerializedName("anhdaidien") val anhdaidien: String
)