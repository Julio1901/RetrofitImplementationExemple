package com.julio.simpleretrofitimplementation.repository

import com.julio.simpleretrofitimplementation.api.RetrofitInstance
import com.julio.simpleretrofitimplementation.model.Post

class Repository {

    suspend fun getPost(): Post {
        return RetrofitInstance.api.getPost()
    }

}