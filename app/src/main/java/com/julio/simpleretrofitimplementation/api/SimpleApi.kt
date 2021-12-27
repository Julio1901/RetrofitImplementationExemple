package com.julio.simpleretrofitimplementation.api

import com.julio.simpleretrofitimplementation.model.Post
import retrofit2.http.DELETE
import retrofit2.http.GET

//02-init

interface SimpleApi {



    //Note: The type return is the same type to dataClass created
    @GET("posts/1")
    suspend fun getPost() : Post



}

//02 - final