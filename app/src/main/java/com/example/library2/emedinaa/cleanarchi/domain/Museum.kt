package com.example.library2.emedinaa.cleanarchi.domain

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.io.Serializable
@Parcelize
data class Museum(
    val id: Int,
    val name: String, val photo: String
) : Parcelable