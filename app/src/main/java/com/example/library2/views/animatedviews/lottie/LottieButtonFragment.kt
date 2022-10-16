package com.example.library2.views.animatedviews.lottie

import android.animation.Animator
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.airbnb.lottie.LottieAnimationView
import com.example.library2.R

class LottieButtonFragment : Fragment(R.layout.lottie_button_layout) {

    private val animationListener = object : Animator.AnimatorListener {
        override fun onAnimationStart(animation: Animator?) {
        }

        override fun onAnimationEnd(animation: Animator?) {
            lottieFavButton.removeAnimatorListener(this)
            viewModel.setAnimationInactive()
        }

        override fun onAnimationCancel(animation: Animator?) {

        }

        override fun onAnimationRepeat(animation: Animator?) {}
    }

    private val viewModel by viewModels<LottieButtonViewModel>()

    private val lottieFavButton: LottieAnimationView
        get() = requireView().findViewById(R.id.fav_button_lav)

    private val buttonLottie: Button
        get() = requireView().findViewById(R.id.buttonLottie)

    private val buttonStop: Button
        get() = requireView().findViewById(R.id.buttonStop)

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
        buttonLottie.setOnClickListener {
            if (lottieFavButton.progress == 0f) {
                lottieFavButton.visibility = View.VISIBLE
                buttonLottie.text = ""
                lottieFavButton.playAnimation()
                lottieFavButton.addAnimatorListener(animationListener)
            } else {
                viewModel.setAnimationInactive()
            }
        }
        buttonStop.setOnClickListener {
            lottieFavButton.progress = 0f
            lottieFavButton.cancelAnimation()
            lottieFavButton.removeAllAnimatorListeners()
            viewModel.setAnimationInactive()
        }
    }
}