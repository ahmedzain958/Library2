package com.example.library2.challenge2convertthreadstocoroutinesviewmodel

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.library2.R
import com.example.library2.databinding.ActivityMainBinding

const val DIE_INDEX_KEY = "die_index_key"
const val DIE_VALUE_KEY = "die_value_key"

class ViewModelCoroutinesMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var imageViews: Array<ImageView>
    private val drawables = arrayOf(
        R.drawable.die_1, R.drawable.die_2,
        R.drawable.die_3, R.drawable.die_4,
        R.drawable.die_5, R.drawable.die_6
    )
    private lateinit var viewModel: CoroutinesViewModel

    /*private val handler = object : Handler(Looper.getMainLooper()) {
        override fun handleMessage(msg: Message) {
            val bundle = msg.data
            val dieIndex = bundle?.getInt(DIE_INDEX_KEY) ?: 0
            val dieValue = bundle?.getInt(DIE_VALUE_KEY) ?: 1
            Log.i(LOG_TAG, "index=$dieIndex, value=$dieValue")
            imageViews[dieIndex].setImageResource(drawables[dieValue - 1])
        }
    }
*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize view binding for view object references
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener {
                viewModel.rollDice(imageViews.indices )
        }
        imageViews = arrayOf(binding.die1, binding.die2, binding.die3, binding.die4, binding.die5)
        viewModel = ViewModelProvider(this)[CoroutinesViewModel::class.java]
        viewModel.dicePair.observe(this) { pair ->
            imageViews[pair.first].setImageResource(drawables[pair.second - 1])
        }
    }

    /**
     * Run some code
     */
    private fun rollTheDice() {
        /*thread(start = true) {
            Thread.sleep(dieIndex * 10L)
            val bundle = Bundle()
            bundle.putInt(DIE_INDEX_KEY, dieIndex)
            for (i in 1..20) {
                bundle.putInt(DIE_VALUE_KEY, getDieValue())
                Message().also {
                    it.data = bundle
                    handler.sendMessage(it)
                }
                Thread.sleep(100)
            }
        }*/
    }

}
