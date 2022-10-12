package com.example.library2.withnavcomponent

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
//if you created class MainFragment : Fragment(R.layout.main_fragment) {, no need to implement onCreateView() call back and oyu can call the following onViewCreated() callback.
    /*override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.i("zainco", "onViewCreated and savedInstanceState=$savedInstanceState")
        FragmentMainBinding.bind(view)
    }*/
}