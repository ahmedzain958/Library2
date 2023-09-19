package com.example.library2.compose.interoperability.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.library2.compose.HorizontalDottedProgress
import com.example.library2.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        _binding!!.composeView.setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .border(border = BorderStroke(1.dp, Color.Black))
                    .padding(16.dp)
            ) {
                Text(text = "composable inside fragment")
                Spacer(modifier = Modifier.padding(10.dp))
                CircularProgressIndicator()
                Spacer(modifier = Modifier.padding(10.dp))
                Text(text = "composable inside fragment")
                Spacer(modifier = Modifier.padding(10.dp))
                Spacer(modifier = Modifier.padding(10.dp))
                val customView = HorizontalDottedProgress(requireContext())
                AndroidView(factory = {customView})
            }
        }

        /*ComposeView(requireContext()).apply {
            setContent {
                Text(text = "From Compose Interoperability")
            }*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

