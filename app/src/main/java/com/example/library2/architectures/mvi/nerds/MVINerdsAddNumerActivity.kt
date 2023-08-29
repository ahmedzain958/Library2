package com.example.library2.architectures.mvi.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.example.library2.R
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch

class MVINerdsAddNumerActivity : AppCompatActivity() {
    private val viewModel: MVINerdsAddNumberViewModel by lazy {
        ViewModelProvider(this)[MVINerdsAddNumberViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvinerds_addnumber)
        /*val edittext = findViewById<EditText>(R.id.edittext)*/
        findViewById<Button>(R.id.button2).setOnClickListener {
            lifecycleScope.launch {
                viewModel.number = findViewById<EditText>(R.id.edittext).text.toString().toInt()
                viewModel.intentChannel.send(MainIntent.AddNumber)
            }
        }
        render()
    }

//    private fun collectMainViewState() {
//        lifecycleScope.launch {
//            viewModel.intentChannel.consumeAsFlow().collect {
//                when (it) {
//                    MainIntent.AddNumber -> {
//                        val input = findViewById<EditText>(R.id.edittext).text.toString().toInt()
//                        viewModel.number = input
//                        viewModel.addNumber()
//                    }
//                }
//            }
//        }
//    }

    //    private fun
    private fun render() {
        lifecycleScope.launch {
            viewModel.stateFlow.collect{
                when (it){
                   is MainViewState.Idle -> findViewById<EditText>(R.id.edittext).setText("")
                    is MainViewState.AddNumber -> findViewById<EditText>(R.id.edittext).setText(it.number.toString())
                    is MainViewState.Error -> findViewById<EditText>(R.id.edittext).setText(it.error)
                    else -> findViewById<EditText>(R.id.edittext).setText("")
                }
            }
        }
    }
}