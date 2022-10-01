package com.example.library2.challenge1runnable

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.databinding.ActivityMainBinding
import kotlin.concurrent.thread
import kotlin.random.Random

const val DICE_INDEX_KEY = "DICE_INDEX_KEY"
const val DRAWABLE_VALUE_KEY = "DRAWABLE_VALUE_KEY"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageViews: Array<ImageView>
    private val drawables: Array<Int> = arrayOf(
        R.drawable.die_1,
        R.drawable.die_2,
        R.drawable.die_3,
        R.drawable.die_4,
        R.drawable.die_5,
        R.drawable.die_6)

    private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val bundle = msg.data
            val imageViewIndex = bundle.getInt(DICE_INDEX_KEY) ?: 0
            val newDieValue = bundle.getInt(DRAWABLE_VALUE_KEY) ?: 1
            imageViews[imageViewIndex].setImageResource(drawables[newDieValue - 1])
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        imageViews = arrayOf(binding.die1, binding.die2, binding.die3, binding.die4, binding.die5)

        setContentView(binding.root)

        binding.rollButton.setOnClickListener { rollTheDice() }

    }

    /**
     * Run some code
     */
    private fun rollTheDice() {
        for (index in imageViews.indices) {
            thread(true) {
                val bundle = Bundle()
                bundle.putInt(DICE_INDEX_KEY, index)
                var i = 0L
                while (i < 1000L) {
                    bundle.putInt(DRAWABLE_VALUE_KEY, getDieValue())
                    Message().also {
                        it.data = bundle
                        handler.sendMessage(it)
                    }
                    i += 100L
                    Thread.sleep(100L)
                }
            }
        }
    }

    /**
     * Get a random number from 1 to 6
     */
    private fun getDieValue(): Int {
        return Random.nextInt(1, 7)
    }

}
