package com.example.library2.coroutines_flows.ui.main

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.library2.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class FlowsPhilipFragment : Fragment() {

    companion object {
        fun newInstance() = FlowsPhilipFragment()
    }

    private lateinit var viewModel: FlowsPhilipViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this)[FlowsPhilipViewModel::class.java]

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_flows_philip, container, false)
        lifecycleScope.launch {


            //collect latest example
            viewModel.countDownFlow.filter { it % 2 == 0 }
                .onEach {
                    view.findViewById<TextView>(R.id.message).text = it.toString()
                }
                .collectLatest {
                    delay(2500)
                    view.findViewById<TextView>(R.id.message).text = it.toString()
                    view.findViewById<TextView>(R.id.message2).text = it.toString()
                    Log.d("FlowsPhilipFragment", "timer = $it")
                }
        }
        return view
    }

}