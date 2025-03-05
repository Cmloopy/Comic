package com.cmloopy.comic.models

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class Chapter (
    @SerializedName("idChapter") val idChapter: Int,
    @SerializedName("nameChapter") val nameChapter: String,
    @SerializedName("viewChapter") val viewChapter: Int,
    @SerializedName("likeChapter") val likeChapter: Int,
    @SerializedName("updatedAt") val updatedAt: Timestamp,
    @SerializedName("urlChapter") val urlChapter: String,
    @SerializedName("idComic") val idComic: Int
)