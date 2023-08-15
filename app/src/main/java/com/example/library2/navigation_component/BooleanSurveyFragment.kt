package com.example.library2.navigation_component

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
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

    val args: NavArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val answer = arguments?.getParcelable("answer") as Answer?
        binding.textviewFirst.text = answer?.questionValue.toString()
        binding.buttonSatisfaction.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
        binding.buttonInput.setOnClickListener {

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