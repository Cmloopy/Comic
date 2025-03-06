package com.cmloopy.comic.data.api

import com.cmloopy.comic.models.Category
import retrofit2.http.GET
import retrofit2.http.Path

interface CategoryApi {
    @GET("category/comic/{idComic}")
    suspend fun getAllCategoryByComicId(@Path("idComic") idComic: Int): ArrayList<Category>
    @GET("category")
    suspend fun getAllCategory(): ArrayList<Category>
}