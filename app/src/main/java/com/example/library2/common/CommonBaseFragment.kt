package com.example.library2.common

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

abstract class CommonBaseFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.isClickable = true
        view.isFocusable = true
        view.setBackgroundColor(Color.WHITE)
    }
}