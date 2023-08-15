package com.example.library2.navigation_component

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.library2.R
import com.example.library2.databinding.FragmentSurveyBooleanBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class BooleanSurveyFragment : Fragment() {

    private var _binding: FragmentSurveyBooleanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        _binding = FragmentSurveyBooleanBinding.inflate(inflater, container, false)
        Log.d("first_fra", "onCreateView() called")
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val navController = findNavController()
        val answer = arguments?.getParcelable("answer") as Answer?
        binding.textviewFirst.text = answer?.questionValue.toString()
        binding.buttonSatisfaction.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonInput.setOnClickListener {

        }
        binding.buttonMultiplechoice.setOnClickListener {

        }
        binding.buttonSameInstance.setOnClickListener {
            val answer = Answer(2, "inside boolean")
            val bundle = bundleOf("answer" to answer)
            navController.navigate(R.id.action_to_booleanSurveyFragment, bundle)
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