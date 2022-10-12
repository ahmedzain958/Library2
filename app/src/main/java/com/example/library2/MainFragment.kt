package com.example.library2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.library2.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i("zainco", "onCreate and savedInstanceState=$savedInstanceState")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       val binding = FragmentMainBinding.inflate(inflater, container, false)

        Log.i("zainco", "onCreateView and savedInstanceState=$savedInstanceState")
        return binding.root
    }
}