package com.shubhamkumarwinner.retrofitmvvm.network

import retrofit2.http.GET

interface UserApiService{
    @GET("users")
    suspend fun getUsers(): List<User>
}
