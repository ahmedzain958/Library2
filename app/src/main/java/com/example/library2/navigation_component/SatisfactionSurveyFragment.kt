package com.example.library2.navigation_component

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.library2.R
import com.example.library2.databinding.FragmentSurveySatisfactionBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class SatisfactionSurveyFragment : Fragment() {
    private var _binding: FragmentSurveySatisfactionBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        _binding = FragmentSurveySatisfactionBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         val navController = findNavController()
        val answer = arguments?.getParcelable("answer") as Answer?
        binding.textviewFirst.text = answer?.questionValue.toString() ?: ""

        binding.buttonBoolean.setOnClickListener {
            val answer = Answer(1, "2")
            val bundle = bundleOf("answer" to answer)
            navController.navigate(R.id.action_to_booleanSurveyFragment, bundle)
//            navController.navigate(action)
        }
        binding.buttonInput.setOnClickListener {

        }
        binding.buttonMultiplechoice.setOnClickListener {

        }
        binding.buttonSameInstance.setOnClickListener {
            val answer = Answer(1, "2")
            val bundle = bundleOf("answer" to answer)
            navController.navigate(R.id.action_to_satisfactionSurveyFragment, bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}