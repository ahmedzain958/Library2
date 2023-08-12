package com.example.library2.concurrentprogramming.coroutines.nerds

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.library2.R

class CoroutineBuilderComponentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine_builder_components)
        //1st Example clarifies that coroutine builder consists of 4 terms
        /**
         * 1. Scope: tells coroutine that it will work in this field/place.
         * Examples of Scope: GlobalScope: working while app lasts, if closed activity/viewmodel or any other thing, it will last
         * 2. Starting: coroutine to be started with await result/ I am not awaiting any result.
         * 3. Thread: In Which thread coroutine will run.
         * 4. Body: Work.
         */


    }
}