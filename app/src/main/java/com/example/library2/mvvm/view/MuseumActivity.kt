package com.example.library2.mvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library2.R
import com.example.library2.mvvm.model.Museum
import com.example.library2.mvvm.viewmodel.MuseumViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MuseumActivity : AppCompatActivity() {
    private  val TAG = "CONSOLE"
    private val viewModel: MuseumViewModel by viewModels()

   /* private val viewModel by viewModels<MuseumViewModel> {
        Injection.provideViewModelFactory()
    }*/
    private lateinit var adapter: MuseumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutError: View
    private lateinit var textViewError: TextView
    private lateinit var layoutEmpty: View
    private lateinit var progressBar: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)
        setupViewModel()
        setupUI()
    }

    //ui
    private fun setupUI() {
        recyclerView = findViewById(R.id.recyclerView)
        layoutError = findViewById(R.id.layoutError)
        layoutEmpty = findViewById(R.id.layoutEmpty)
        progressBar = findViewById(R.id.progressBar)
        textViewError = findViewById(R.id.textViewError)

        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList())
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel.museums.observe(this, renderMuseums)
        viewModel.isLoading.observe(this, isViewLoadingObserver)
        viewModel.onMessageError.observe(this, onMessageErrorObserver)
        viewModel.isEmptyList.observe(this, emptyListObserver)
    }

    //observers
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
    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
}