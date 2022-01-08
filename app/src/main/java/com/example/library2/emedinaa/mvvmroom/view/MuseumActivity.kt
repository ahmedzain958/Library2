package com.example.library2.emedinaa.mvvmroom.view

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.emedinaa.kotlinmvvm.view.MuseumAdapter
import com.example.library2.R
import com.example.library2.emedinaa.mvvmroom.di.Injection
import com.example.library2.emedinaa.mvvmroom.model.Museum
import com.example.library2.emedinaa.mvvmroom.viewmodel.MuseumViewModel
import com.example.library2.emedinaa.mvvmroom.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_museum.*
import kotlinx.android.synthetic.main.layout_error.*

class MuseumActivity : AppCompatActivity() {

    private lateinit var viewModel: MuseumViewModel
    private lateinit var adapter: MuseumAdapter

    companion object {
        const val TAG = "CONSOLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)
        setupViewModel()
        setupUI()
    }

    // region setup ui
    private fun setupUI() {
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }
    // endregion setup ui

    // region setup viewmodel
    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(Injection.providerRepository())).get(
            MuseumViewModel::class.java
        )
        viewModel.museums.observe(this,renderMuseums)
        viewModel.isViewLoading.observe(this, isViewLoadingObserver)
    }
    // endregion viewmodel

    //region observers
    private val renderMuseums = Observer<List<Museum>> {
        Log.v(TAG, "data updated $it")
        layoutError.visibility = View.GONE
        layoutEmpty.visibility = View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver = Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")
        val visibility = if (it) View.VISIBLE else View.GONE
        progressBar.visibility = visibility
    }

    private val onMessageErrorObserver = Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        layoutError.visibility = View.VISIBLE
        layoutEmpty.visibility = View.GONE
        textViewError.text = "Error $it"
    }

    private val emptyListObserver = Observer<Boolean> {
        Log.v(TAG, "emptyListObserver $it")
        layoutEmpty.visibility = View.VISIBLE
        layoutError.visibility = View.GONE
    }
    //endregion observers

    //If you require updated data, you can call the method "loadMuseum" here
    override fun onResume() {
        super.onResume()
        viewModel.retrieveMuseums()
    }

}
