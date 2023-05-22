package com.example.library2.views

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.LinearInterpolator
import androidx.core.graphics.withRotation

class ProgressView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val background = Paint().apply {
        color = Color.argb(0, 0, 0, 0)
    }

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#b49164")
        strokeWidth = 15f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG).apply {
        color = Color.parseColor("#FFc7ad8b")
        strokeWidth = 15f
        strokeCap = Paint.Cap.ROUND
        strokeJoin = Paint.Join.ROUND
    }

    private var a = 0f
    private var a2 = 0f

    init {
        startRotation()
        startColorRotation()
    }

    private fun startRotation() {
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 3000
        animator.addUpdateListener {
            a = it.animatedFraction
            invalidate()
        }
        animator.start()
    }

    private fun startColorRotation() {
        val animator = ValueAnimator.ofFloat(0f, 1f)
        animator.repeatCount = ValueAnimator.INFINITE
        animator.interpolator = LinearInterpolator()
        animator.duration = 900
        animator.addUpdateListener {
            a2 = it.animatedFraction
            invalidate()
        }
        animator.start()
    }

    override fun onDraw(canvas: Canvas) {
        canvas.apply {
            drawRect(0f, 0f, width.toFloat(), height.toFloat(), background)
            withRotation(degrees = 360 * a, pivotX = width / 2f, pivotY = height / 2f) {
                repeat(8) {
                    withRotation(360 / 8f * it, pivotX = width / 2f, height / 2f) {
                        drawLine(
                            width / 2f,
                            height / 2f - height / 3.5f,
                            width / 2f,
                            height / 10f,
                            if (((1 - a2) * 8).toInt() == it) {
                                paint2
                            } else {
                                paint
                            }
                        )
                    }
                }
            }
        }
    }
}