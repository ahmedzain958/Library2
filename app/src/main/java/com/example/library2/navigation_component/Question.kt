package com.example.library2.navigation_component

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Question(
        @SerializedName("QuestionId")
        val questionID: Long?,
        @SerializedName("Order")
        val order: Long?,
        @SerializedName("Description")
        val description: String?,
        @SerializedName("Required")
        val required: Boolean?,
        @SerializedName("ValueType")
        val valueType: Long?,
        @SerializedName("ThresholdValue")
        val thresholdValue: Long? = null,
        @SerializedName("ThresholdOperation")
        val thresholdOperation: Long? = null,
        @SerializedName("RelatedQuestions")
        val relatedQuestions: List<Question>?,
        @SerializedName("Options")
        val options: List<Option>?
) : Serializable