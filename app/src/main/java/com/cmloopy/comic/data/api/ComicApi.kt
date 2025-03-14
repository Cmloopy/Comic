package com.cmloopy.comic.data.api

import Comic
import retrofit2.http.GET
import retrofit2.http.POST
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
    @GET("comic/category/{nameCategory}")
    suspend fun getComicByCategory(@Path("nameCategory") nameCategory: String): ArrayList<Comic>
    @POST("comic/updateLike/{idComic}")
    suspend fun updateLikes(@Path("idComic") idComic: Int)

    @POST("comic/updateView/{idComic}")
    suspend fun updateViews(@Path("idComic") idComic: Int)
}