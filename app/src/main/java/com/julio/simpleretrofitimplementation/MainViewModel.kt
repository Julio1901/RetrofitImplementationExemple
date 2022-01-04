package com.julio.simpleretrofitimplementation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julio.simpleretrofitimplementation.api.model.JsonPlaceHolderPost
import com.julio.simpleretrofitimplementation.model.Post
import com.julio.simpleretrofitimplementation.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Post> = MutableLiveData()
    val myPostResponse : MutableLiveData<Post> = MutableLiveData()
    val myUpdateResponse : MutableLiveData<Post> = MutableLiveData()
    val myDeleteResponse : MutableLiveData<Response<Post>> = MutableLiveData()




    fun getPost(){
        //Get post in outer thread and set it in liveDate
        viewModelScope.launch {
            val response : Post = repository.getPost()
            myResponse.value = response
        }
    }

    fun createNewPost(newPost : JsonPlaceHolderPost){

        viewModelScope.launch {
            myPostResponse.value = repository.createNewPost(newPost)
        }
    }

    fun updatePost (postToUpdate : Post){
        viewModelScope.launch {
            myUpdateResponse.value = repository.updatePost(postToUpdate)
        }
    }

    fun deletePost(postToDelete : Post){
        viewModelScope.launch {
            myDeleteResponse.value = repository.deletePost(postToDelete)
        }
    }


}