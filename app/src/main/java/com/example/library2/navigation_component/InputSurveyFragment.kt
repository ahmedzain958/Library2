package com.example.library2.navigation_component

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.library2.databinding.FragmentSurveyInputBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class InputSurveyFragment : Fragment() {

    private var _binding: FragmentSurveyInputBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentSurveyInputBinding.inflate(inflater, container, false)
        Log.d("first_fra", "onCreateView() called")
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("first_fra", "onViewCreated() called")
        binding.buttonBoolean.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonSatisfaction.setOnClickListener {

        }
        binding.buttonMultiplechoice.setOnClickListener {

        }
        binding.buttonSameinstance.setOnClickListener {

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("first_fra", "onDestroyView() called")
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("first_fra", "onDestroy() called")
    }
}