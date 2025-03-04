package com.cmloopy.comic.data.api

import Comic
import retrofit2.Call
import retrofit2.http.GET

interface ComicApi {
    @GET("/comic/hot")
    fun getComicHot():Call<List<Comic>>
    @GET("/comic/finish")
    fun getComicHT(): Call<List<Comic>>
    @GET("/comic/like")
    fun getComicLike(): Call<List<Comic>>
}