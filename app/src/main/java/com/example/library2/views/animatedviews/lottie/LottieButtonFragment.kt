package com.example.library2.views.animatedviews.lottie

import android.animation.Animator
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.example.library2.R

class LottieButtonFragment : Fragment(R.layout.lottie_button_layout) {

    private val viewModel by viewModels<LottieButtonViewModel>()

    private val lottieFavButton: LottieAnimationView
        get() = requireView().findViewById(R.id.fav_button_lav)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservers()
        setClickListeners()
    }

    private fun setObservers() {
        viewModel.isFavButtonActive.observe(viewLifecycleOwner, ::onFavButtonStateUpdated)
    }

    private fun onFavButtonStateUpdated(isActive: Boolean) {
        lottieFavButton.progress = if (isActive) 1f else 0f
    }

    private fun setClickListeners() {
        lottieFavButton.setOnClickListener {
            if (lottieFavButton.progress == 0f) {
                lottieFavButton.playAnimation()
                lottieFavButton.addAnimatorListener(object : Animator.AnimatorListener {
                    override fun onAnimationStart(animation: Animator?) {
                        // Ignore
                    }

                    override fun onAnimationEnd(animation: Animator?) {
                        lottieFavButton.removeAnimatorListener(this)
                        viewModel.toggleFavButtonState()
                    }

                    override fun onAnimationCancel(animation: Animator?) {
                        // Ignore
                    }

                    override fun onAnimationRepeat(animation: Animator?) {
                        // Ignore
                    }
                })
            } else {
                viewModel.toggleFavButtonState()
            }
        }
    }
}