package com.julio.simpleretrofitimplementation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.julio.simpleretrofitimplementation.model.Post
import com.julio.simpleretrofitimplementation.repository.Repository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository): ViewModel() {

    val myResponse : MutableLiveData<Post> = MutableLiveData()



    fun getPost(){
        //Get post in outer trhed and set it in liveDate
        viewModelScope.launch {
            val response : Post = repository.getPost()
            myResponse.value = response
        }


    }


}