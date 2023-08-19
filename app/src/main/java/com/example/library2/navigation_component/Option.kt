package com.example.library2.navigation_component

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Option(
        @SerializedName("OptionName")
        val optionName: String,
        @SerializedName("OptionValue")
        val optionValue: String,
        @SerializedName("OptionOrder")
        val optionOrder: String
) : Serializable