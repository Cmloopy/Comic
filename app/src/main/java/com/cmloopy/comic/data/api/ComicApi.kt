package com.cmloopy.comic.data.api

import Comic
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ComicApi {
    @GET("comic/hot")
    suspend fun getComicHot():ArrayList<Comic>
    @GET("comic/like")
    suspend fun getComicLike():ArrayList<Comic>
    @GET("comic/finish")
    suspend fun getComicHT(): ArrayList<Comic>
    @GET("comic/allfinish")
    suspend fun getAllComicHT(): ArrayList<Comic>
    @GET("comic/newUpdate")
    suspend fun getComicUpdate(): ArrayList<Comic>
    @GET("comic/allNewUpdate")
    suspend fun getAllComicUpdate(): ArrayList<Comic>
    @GET("comic/{idComic}")
    suspend fun getComicById(@Path("idComic") idComic: Int): ArrayList<Comic>
}