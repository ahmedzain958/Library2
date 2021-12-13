package com.example.library2.mvvm2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.emedinaa.kotlinmvvm.viewmodel.ViewModelFactory
import com.example.library2.R
import com.example.library2.mvvm2.di.Injection
import com.example.library2.mvvm2.viewmodel.MuseumViewModel

class MuseumActivity : AppCompatActivity() {
    private lateinit var viewModel: MuseumViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum2)
        setupViewModel()
    }
    //viewmodel
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(Injection.providerRepository()))
            .get(MuseumViewModel::class.java)

    }
    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }
}