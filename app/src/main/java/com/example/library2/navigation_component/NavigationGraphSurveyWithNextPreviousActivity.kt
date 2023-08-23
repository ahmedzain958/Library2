package com.example.library2.navigation_component

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavInflater
import androidx.navigation.fragment.NavHostFragment
import com.example.library2.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class NavigationGraphSurveyWithNextPreviousActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private val surveyViewModel: SurveyViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation_graph_survey_with_next_previous)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        //due to each nav host fragment has a nav controller, we have no need for the following code, as long the navgraph already given in the design time
        /*val inflater: NavInflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        navHostFragment.navController.graph = graph*/
        navController = navHostFragment.navController
        initCollectors()
        surveyViewModel.fetchSurveyDetails(20382375, 1)

        lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                surveyViewModel.getQuestionsList().collect{
                    Log.d("zainco", "$it")
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
    private fun initCollectors() {
        lifecycleScope.launchWhenStarted {
            surveyViewModel.uiState.collectLatest { state ->
                when (state) {
                    is SurveyViewModel.UiState.UpdateSurveyData -> {
                        Log.d("zainco", "first question ${state.sortedQuestions}")
                        displayNavigationQuestions(state.sortedQuestions)
                    }
                    else -> {}
                }

            }
        }
    }
    private fun displayNavigationQuestions(questionsList: List<Question>) {
        val iterator = questionsList.iterator()
        navigateToNextQuestion(iterator)
        if (iterator.hasNext()) {
            val question = iterator.next()
        }
    }
    private fun navigateToNextQuestion(iterator: Iterator<Question>) {
        if (iterator.hasNext()) {
            val question = iterator.next()
            val action = when (question.valueType) {
             /*   QuestionValueType.RATING.valueType -> SurveyRatingQuestionFragmentDirections.actionToSurveyRatingQuestionFragment(question)
                QuestionValueType.CHOICES.valueType -> SurveyChoicesQuestionFragmentDirections.actionToSurveyChoicesQuestionFragment(question)
                QuestionValueType.OPEN_ENDED.valueType -> SurveyOpenEndedQuestionFragmentDirections.actionToSurveyOpenEndedQuestionFragment(question)
                QuestionValueType.BOOLEAN.valueType -> SurveyBooleanQuestionFragmentDirections.actionToSurveyBooleanQuestionFragment(question)*/
                else -> null // Handle unknown question types if needed
            }

            if (action != null) {
//                navController.navigate(action)
            }

            // Handle related questions recursively
            question.relatedQuestions?.let { relatedQuestions ->
                navigateToNextQuestion(relatedQuestions.iterator())
            }
        }
    }
}