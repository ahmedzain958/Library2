package com.example.library2.google

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.library2.R
import com.example.library2.BR
import com.example.library2.databinding.IntervalTimerBinding
import com.example.library2.google.data.IntervalTimerViewModelFactory
import com.example.library2.google.ui.IntervalTimerViewModel
const val SHARED_PREFS_KEY = "timer"

class TwoWayDBActivity : AppCompatActivity() {
    private val intervalTimerViewModel: IntervalTimerViewModel
            by lazy {
                ViewModelProvider(this, IntervalTimerViewModelFactory)
                    .get(IntervalTimerViewModel::class.java)
            }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interval_timer)
        val binding: IntervalTimerBinding = DataBindingUtil.setContentView(
            this, R.layout.interval_timer)
        binding.viewmodel = intervalTimerViewModel
        /* Save the user settings whenever they change */
        observeAndSaveTimePerSet(
            intervalTimerViewModel.timePerWorkSet, R.string.prefs_timePerWorkSet)
        observeAndSaveTimePerSet(
            intervalTimerViewModel.timePerRestSet, R.string.prefs_timePerRestSet)

        /* Number of sets needs a different  */
        observeAndSaveNumberOfSets(intervalTimerViewModel)

        if (savedInstanceState == null) {
            /* If this is the first run, restore shared settings */
            restorePreferences(intervalTimerViewModel)
            observeAndSaveNumberOfSets(intervalTimerViewModel)
        }
    }
    private fun observeAndSaveTimePerSet(timePerWorkSet: ObservableInt, prefsKey: Int) {
        timePerWorkSet.addOnPropertyChangedCallback(
            object : Observable.OnPropertyChangedCallback() {
                @SuppressLint("CommitPrefEdits")
                override fun onPropertyChanged(observable: Observable?, p1: Int) {
                    Log.d("saveTimePerWorkSet", "Saving time-per-set preference")
                    val sharedPref =
                        getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
                    sharedPref.edit().apply {
                        putInt(getString(prefsKey), (observable as ObservableInt).get())
                        commit()
                    }
                }
            })
    }

    private fun restorePreferences(viewModel: IntervalTimerViewModel) {
        val sharedPref =
            getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
        val timePerWorkSetKey = getString(R.string.prefs_timePerWorkSet)
        var wasAnythingRestored = false
        if (sharedPref.contains(timePerWorkSetKey)) {
            viewModel.timePerWorkSet.set(sharedPref.getInt(timePerWorkSetKey, 100))
            wasAnythingRestored = true
        }
        val timePerRestSetKey = getString(R.string.prefs_timePerRestSet)
        if (sharedPref.contains(timePerRestSetKey)) {
            viewModel.timePerRestSet.set(sharedPref.getInt(timePerRestSetKey, 50))
            wasAnythingRestored = true
        }
        val numberOfSetsKey = getString(R.string.prefs_numberOfSets)
        if (sharedPref.contains(numberOfSetsKey)) {
            viewModel.numberOfSets = arrayOf(0, sharedPref.getInt(numberOfSetsKey, 5))
            wasAnythingRestored = true
        }
        if (wasAnythingRestored) Log.d("saveTimePerWorkSet", "Preferences restored")
        viewModel.stopButtonClicked()
    }

    private fun observeAndSaveNumberOfSets(viewModel: IntervalTimerViewModel) {
        viewModel.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            @SuppressLint("CommitPrefEdits")
            override fun onPropertyChanged(observable: Observable?, p1: Int) {
                if (p1 == BR.numberOfSets) {
                    Log.d("saveTimePerWorkSet", "Saving number of sets preference")
                    val sharedPref =
                        getSharedPreferences(SHARED_PREFS_KEY, Context.MODE_PRIVATE) ?: return
                    sharedPref.edit().apply {
                        putInt(getString(R.string.prefs_numberOfSets), viewModel.numberOfSets[1])
                        commit()
                    }
                }
            }
        })
    }
}