package com.example.library2.navigation_component


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Answer(
    @SerializedName("QuestionId")
    val questionId: Int?,
    @SerializedName("QuestionValue")
    val questionValue: String?
): Parcelable