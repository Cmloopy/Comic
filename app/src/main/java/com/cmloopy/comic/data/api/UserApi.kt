package com.cmloopy.comic.data.api

import com.cmloopy.comic.models.User
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface UserApi {
    @GET("user/check/{username}&{pass}")
    suspend fun checkLogin(@Path("username") username: String,@Path("pass") pass:String ): ArrayList<User>
    @GET("user/{idUser}")
    suspend fun getUserById(@Path("idUser") idUser: Int): ArrayList<User>
    @POST("user/updateView/{idUser}")
    suspend fun updateUserView(@Path("idUser") idUser: Int)
}