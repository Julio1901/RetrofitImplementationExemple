package com.julio.simpleretrofitimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.julio.simpleretrofitimplementation.api.model.JsonPlaceHolderPost
import com.julio.simpleretrofitimplementation.model.Post
import com.julio.simpleretrofitimplementation.repository.Repository

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel : MainViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        val textViewHelloWorld : TextView = findViewById(R.id.text_view_hello_word)


        viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        // In this moment us call a function to be executed in a different thread

        // Simulating a GET action
        viewModel.getPost()


        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.userId.toString())
            Log.d("Response", response.id.toString())
            Log.d("Response", response.title)
            Log.d("Response", response.body)

            textViewHelloWorld.setText(response.title)

        })

        // Simulating a POST action
        val newPost = JsonPlaceHolderPost("Mock Post", "This is a mock post.", 10)

        viewModel.createNewPost(newPost)


        viewModel.myPostResponse.observe(this, Observer {
            Log.d("Post Response", it.id.toString())
            Log.d("Post Response", it.title)

        })


        // Simulating a PUT action
        val postChanged = Post(1 ,1, "Post Changed","This is a mock post. It has been changed")

        viewModel.updatePost(postChanged)

        viewModel.myUpdateResponse.observe(this , Observer {
            Log.d("Post changed", it.body)

        })

        // Simulating a DELETE action

        val postToDelete = Post(1 ,1, "Post Changed","This is a mock post. It has deleted")
        viewModel.deletePost(postToDelete)

        viewModel.myDeleteResponse.observe(this, Observer {
            if (it.isSuccessful){
                Log.d("Post Deleted", it.code().toString())
            }
        })

    }

}