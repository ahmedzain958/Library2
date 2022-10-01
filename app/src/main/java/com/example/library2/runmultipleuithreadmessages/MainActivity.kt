package com.example.library2.runmultipleuithreadmessages

import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.example.library2.R
import com.example.library2.databinding.ActivityMainBinding
import kotlin.concurrent.thread
import kotlin.random.Random
const val DIE_INDEX = "DIE_INDEX"
const val NEW_DIE_VALUE = "NEW_DIE_VALUE"
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageViews: Array<ImageView>
    private lateinit var drawables: Array<Int>
    val handler = object : Handler(){
        override fun handleMessage(msg: Message) {
            val bundle = msg.data
            val dieIndex = bundle?.getInt(DIE_INDEX) ?: 0
            val newDieValue = bundle?.getInt(NEW_DIE_VALUE) ?: 1
            imageViews[dieIndex].setImageResource(drawables[newDieValue - 1])

        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener { rollTheDice() }

    }

    /**
     * Run some code
     */
    private fun rollTheDice() {
        imageViews = arrayOf(binding.die1, binding.die2, binding.die3, binding.die4, binding.die5)
        drawables = arrayOf(
            R.drawable.die_1,
            R.drawable.die_2,
            R.drawable.die_3,
            R.drawable.die_4,
            R.drawable.die_5,
            R.drawable.die_6
        )
        for (dieIndex in imageViews.indices) {
            thread(start = true) {
                val bundle = Bundle()
                bundle.putInt(DIE_INDEX, dieIndex)
                for (i in 1..20){
                    bundle.putInt(NEW_DIE_VALUE, getDieValue())
                    Message().also {
                        it.data = bundle
                        handler.sendMessage(it)
                    }
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
