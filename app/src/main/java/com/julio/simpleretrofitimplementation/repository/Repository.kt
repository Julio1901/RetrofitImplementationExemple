package com.julio.simpleretrofitimplementation.repository

import com.julio.simpleretrofitimplementation.api.RetrofitInstance
import com.julio.simpleretrofitimplementation.api.model.JsonPlaceHolderPost
import com.julio.simpleretrofitimplementation.model.Post
import retrofit2.Response

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }

    suspend fun createNewPost(newPost : JsonPlaceHolderPost) : Post{
        return RetrofitInstance.api.createNewPost(newPost)
    }

    suspend fun updatePost(postToUpdate : Post) : Post {
        return RetrofitInstance.api.updatePost(postToUpdate, postToUpdate.id)
    }

    suspend fun deletePost (postToDelete : Post) : Response<Post>{
        return RetrofitInstance.api.deletePost(postToDelete.id)
    }
}