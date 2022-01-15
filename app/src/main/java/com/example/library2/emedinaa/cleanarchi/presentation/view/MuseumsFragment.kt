package com.example.library2.emedinaa.cleanarchi.presentation.view

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.library2.R
import com.example.library2.emedinaa.cleanarchi.domain.Museum
import com.example.library2.emedinaa.cleanarchi.presentation.viewmodel.MuseumViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MuseumsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
@AndroidEntryPoint
class MuseumsFragment : Fragment() {
    private lateinit var adapter: MuseumAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutError: View
    private lateinit var layoutEmpty: View
    private lateinit var progressBar: View
    private lateinit var textViewError: TextView
    private val viewModel: MuseumViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_museums, container, false)
    }

    private fun setupUI(view: View) {
        recyclerView = view.findViewById(R.id.recyclerView)
        layoutError = view.findViewById(R.id.layoutError)
        layoutEmpty = view.findViewById(R.id.layoutEmpty)
        progressBar = view.findViewById(R.id.progressBar)
        textViewError = view.findViewById(R.id.textViewError)
        val myPlay = object : Play {
            override fun printRorL(textView: TextView) {
                textView.text = "Right"
            }

            override fun directTO(museum: Museum) {
                goToMuseumDetailView(museum)
            }
        }
        adapter = MuseumAdapter(viewModel.museums.value ?: emptyList(), myPlay)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
    }

    private fun setupViewModel() {
        viewModel.museums.observe(viewLifecycleOwner, renderMuseums)
        viewModel.isViewLoading.observe(viewLifecycleOwner, isViewLoadingObserver)
        viewModel.onMessageError.observe(viewLifecycleOwner, onMessageErrorObserver)
        viewModel.isEmptyList.observe(viewLifecycleOwner, emptyListObserver)
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


    private fun goToMuseumDetailView(museum: Museum) {
        findNavController().navigate(R.id.action_museumsFragment_to_museumDetailFragment,
            Bundle().apply {
                putParcelable("MUSEUM", museum)
            })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupUI(view)
    }

    //If you require updated data, you can call the method "loadMuseum" here
    override fun onResume() {
        super.onResume()
        viewModel.loadMuseums()
    }
}