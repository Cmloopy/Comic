package com.cmloopy.comic.data.api

import com.cmloopy.comic.models.Chapter
import retrofit2.http.GET
import retrofit2.http.Path

interface ChapterApi {
    @GET("chapter/comic/{idComic}")
    suspend fun getChapterByIdComic(@Path("idComic") idComic: Int): ArrayList<Chapter>
}