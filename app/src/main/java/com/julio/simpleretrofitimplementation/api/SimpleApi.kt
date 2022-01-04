package com.julio.simpleretrofitimplementation.api

import com.julio.simpleretrofitimplementation.api.model.JsonPlaceHolderPost
import com.julio.simpleretrofitimplementation.model.Post
import retrofit2.Response
import retrofit2.http.*



interface SimpleApi {



    //Note: The type return is the same type to dataClass created
    @GET("posts/1")
    suspend fun getPost() : Post

    @POST("posts")
    suspend fun createNewPost(@Body newPost : JsonPlaceHolderPost)  : Post

    @PUT("posts/{id}")
    suspend fun updatePost(@Body postToChanged : Post, @Path("id") id : Int) : Post

    @DELETE("posts/{id}")
    suspend fun deletePost(@Path("id") id : Int) : Response<Post>




}
