package com.example.library2.emedinaa.flow.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.library2.R
import com.example.library2.emedinaa.flow.di.Injection
import com.example.library2.emedinaa.flow.model.Museum
import com.example.library2.emedinaa.flow.viewmodel.MuseumViewModel
import com.example.library2.emedinaa.flow.viewmodel.ViewModelFactory
import kotlinx.android.synthetic.main.activity_museum.*
import kotlinx.android.synthetic.main.layout_error.*

/**
 * @author : Eduardo Medina
 */
class MuseumActivity : AppCompatActivity() {

    private  val  viewModel: MuseumViewModel by viewModels{
        ViewModelFactory(Injection.providerRepository())
    }
    private lateinit var adapter: MuseumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_museum)

        setupObservers()
        setupUI()
    }

    private fun setupUI(){
        adapter= MuseumAdapter(emptyList())
        recyclerView.layoutManager= LinearLayoutManager(this)
        recyclerView.adapter= adapter
    }

    private fun setupObservers(){
        viewModel.isViewLoading.observe(this,isViewLoadingObserver)
        viewModel.onMessageError.observe(this,onMessageErrorObserver)
        viewModel.isEmptyList.observe(this,emptyListObserver)
    }

    private val renderMuseums= Observer<List<Museum>> {
        Log.v(TAG, "data updated $it")
        layoutError.visibility=View.GONE
        layoutEmpty.visibility=View.GONE
        adapter.update(it)
    }

    private val isViewLoadingObserver= Observer<Boolean> {
        Log.v(TAG, "isViewLoading $it")
        val visibility=if(it)View.VISIBLE else View.GONE
        progressBar.visibility= visibility
    }

    private val onMessageErrorObserver= Observer<Any> {
        Log.v(TAG, "onMessageError $it")
        layoutError.visibility=View.VISIBLE
        layoutEmpty.visibility=View.GONE
        textViewError.text= "Error $it"
    }

    private val emptyListObserver= Observer<Boolean> {
        Log.v(TAG, "emptyListObserver $it")
        layoutEmpty.visibility=View.VISIBLE
        layoutError.visibility=View.GONE
    }

     override fun onResume() {
        super.onResume()
         viewModel.loadMuseumsFlow().observe(this,renderMuseums)
     }

    companion object {
        const val TAG= "CONSOLE"
    }

}
