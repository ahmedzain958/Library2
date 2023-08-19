package com.example.library2.navigation_component

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch

class SurveyViewModel : ViewModel() {
    private val _uiState =
        MutableStateFlow<UiState>(UiState.Ideal)
    val uiState = _uiState.asSharedFlow()
    val optionsOfQuestion3 = listOf(
        Option("لا ينطبق", "0", "1"),
        Option("غير راضٍ تمامًا", "1", "2"),
        Option("غير راضٍ", "2", "3"),
        Option("راضٍ", "4", "5"),
        Option("راضٍ تمامًا", "5", "6")
    )
    val optionsOfQuestion6 = listOf(
        Option("لا ينطبق", "0", "1"),
        Option("غير راضٍ تمامًا", "1", "2"),
        Option("غير راضٍ", "2", "3"),
        Option("راضٍ", "4", "5"),
        Option("راضٍ تمامًا", "5", "6")
    )
    val booleanRelatedQuestion12 =
        listOf(Question(122, 1, "related question of Question 12", false, 5, null, 2, null, null))
    val booleanRelatedQuestion9 =
        listOf(Question(99, 1, "related question of Question 12", false, 5, null, 2, null, null))
    val ratingRelatedQuestion = listOf(
        Question(
            111, 1, "ما مدى رضاك عن سهولة إجراءات الحصول على خدمة النقل إلى المدينة المنورة؟", true,
            1, null, null, null, null
        ),
        Question(
            112,
            2,
            "ما مدى رضاك عن سهولة إجراءات الحصول على خدمة النقل إلى المدينة المنورة؟2",
            true,
            1,
            null,
            null,
            null,
            null
        ),
        Question(
            113,
            3,
            "3ما مدى رضاك عن سهولة إجراءات الحصول على خدمة النقل إلى المدينة المنورة؟",
            true,
            1,
            null,
            null,
            null,
            null
        ),
        Question(
            114,
            4,
            "ما مدى رضاك عن سهولة إجراءات الحصول على خدمة النقل إلى المدينة المنورة؟4",
            true,
            1,
            null,
            null,
            null,
            null
        )
    )
    val questionsList = listOf(
        Question(5, 5, "Question 5", true, 5, 1, 2, null, null),
        Question(2, 2, "Question 2", false, 4, null, 2, null, null),
        Question(1, 1, "Question 1", false, 1, 3, 2, ratingRelatedQuestion, null),
        Question(
            3,
            3,
            "Question 3",
            true,
            2,
            0,
            2,
            null,
            optionsOfQuestion3
        ),//value type 2 must have options
        Question(6, 6, "Question 6", false, 2, 0, 2, null, optionsOfQuestion6),
        Question(4, 4, "Question 4", false, 1, 4, 2, ratingRelatedQuestion, null),
        Question(7, 7, "Question 7", true, 5, 0, 2, null, null),
        Question(8, 8, "Question 8", false, 5, 1, 2, null, null),
        Question(10, 10, "Question 10", true, 5, 1, 2, null, null),
        Question(12, 12, "Question 12", false, 5, null, 2, booleanRelatedQuestion12, null),
        Question(9, 9, "Question 9", true, 5, null, 2, booleanRelatedQuestion9, null),
        Question(11, 11, "Question 11", true, 5, 0, 2, null, null),
    )

    fun fetchSurveyDetails(
        reservationId: Int,
        categoryId: Int,
    ) {
        viewModelScope.launch {
            getQuestionsList().collect {
                _uiState.emit(UiState.UpdateSurveyData(questionsList, false))
                }
            }
        }

    /*

 Rating  >> 1
 stars >>  values starts from 1 to 5
 -choices >> type_id >> 2
  you will find options inside the json for each question with type 2
  Open-ended questions  >>  type_id >> 4
  Boolean  >>  type_id >> 5
 >>>>  Yes (1) / No (0)
 */
    fun getQuestionsList(): Flow<List<Question>> {
        return flow { questionsList }
    }

    sealed class UiState {
        object Ideal : UiState()
        object Loading : UiState()
        object SoftLoading : UiState()
        class Error(val message: String?, val errorCode: Int?) : UiState()

        class UpdateSurveyData(
            val sortedQuestions: List<Question>,
            val isExceptional: Boolean,
        ) : UiState()


    }
}