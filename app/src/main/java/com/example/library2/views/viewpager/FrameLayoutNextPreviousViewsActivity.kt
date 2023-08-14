package com.example.library2.views.viewpager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import androidx.lifecycle.ViewModelProvider
import com.example.library2.R

class FrameLayoutNextPreviousViewsActivity : AppCompatActivity() {


    private lateinit var viewContainer: FrameLayout
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button

    private val viewLayouts = listOf(
        R.layout.layout_view_input,
        R.layout.layout_view_boolean,
        R.layout.layout_view_input
        // Add more layout resources as needed
    )

    private var currentViewIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_framelayout_next_previous_views)

        viewContainer = findViewById<FrameLayout>(R.id.viewContainer)
        nextButton = findViewById<Button>(R.id.nextButton)
        prevButton = findViewById<Button>(R.id.prevButton)

        showCurrentView()
        val userInputViewModel = ViewModelProvider(this)[UserInputViewModel::class.java]

        nextButton.setOnClickListener {
           val currentDisplayedVIew =  getCurrentViewWithIndex(currentViewIndex)
            val input = currentDisplayedVIew.findViewById<EditText>(R.id.editTextText)
            val userInput = input.text.toString()
            userInputViewModel.setUserInput(userInput)

            if (currentViewIndex < viewLayouts.size - 1) {
                currentViewIndex++
                showCurrentView()
            }
        }

        prevButton.setOnClickListener {
            if (currentViewIndex > 0) {
                currentViewIndex--
                showCurrentView()
            }
        }
    }

    private fun showCurrentView() {
        val layoutRes = viewLayouts[currentViewIndex]
        val view = layoutInflater.inflate(layoutRes, viewContainer, false)
        viewContainer.removeAllViews()
        viewContainer.addView(view)
    }

    private fun getCurrentViewWithIndex(index: Int): View {
        val layoutRes = viewLayouts[index]
        return layoutInflater.inflate(layoutRes, viewContainer, false)
    }

}