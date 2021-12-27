package com.julio.simpleretrofitimplementation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
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

        //In this moment us call a function to be executed in a different thread
        viewModel.getPost()


        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.userId.toString())
            Log.d("Response", response.id.toString())
            Log.d("Response", response.title)
            Log.d("Response", response.body)

            textViewHelloWorld.setText(response.title)

        })

    }




}