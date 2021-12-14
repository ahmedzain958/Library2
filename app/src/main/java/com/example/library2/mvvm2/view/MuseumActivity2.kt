package com.example.library2.mvvm2.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.kotlinmvvm.viewmodel.ViewModelFactory
import com.example.library2.R
import com.example.library2.databinding.ActivityMuseum2Binding
import com.example.library2.mvvm2.di.Injection
import com.example.library2.mvvm2.model.Museum
import com.example.library2.mvvm2.viewmodel.MuseumViewModel

class MuseumActivity2 : AppCompatActivity() {
    private lateinit var viewModel: MuseumViewModel
    private lateinit var binding: ActivityMuseum2Binding
    private lateinit var adapter: MuseumAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMuseum2Binding.inflate(layoutInflater)
        setContentView(binding.root)
        setupViewModel()
        setupUI()
    }
    //ui
    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter
    }
    //viewmodel
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(Injection.providerRepository()))
            .get(MuseumViewModel::class.java)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
        viewModel.museums.observe(this, renderMuseumsObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

   private val renderMuseumsObserver = Observer<List<Museum>> {
       binding.layoutError.root.visibility = View.GONE
       binding.layoutEmpty.root.visibility = View.GONE
       adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        val visibility = if (it) View.VISIBLE else View.GONE
        binding.progressBar.visibility = visibility
    }
    private val onMessageErrorObserver = Observer<Any> {
        binding.layoutError.root.visibility = View.VISIBLE
        binding.layoutEmpty.root.visibility = View.GONE
        binding.layoutError.textViewError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        binding.layoutEmpty.root.visibility = View.VISIBLE
        binding.layoutError.root.visibility = View.GONE
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }
}