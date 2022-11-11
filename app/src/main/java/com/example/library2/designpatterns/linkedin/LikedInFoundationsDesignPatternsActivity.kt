package com.example.library2.designpatterns.linkedin

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.library2.R
import com.example.library2.databinding.ActivityLikedInFoundationsDesignPatternsBinding
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses.BasicCameraApp
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses.CameraPlusApp
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses.PhoneCameraApp

class LikedInFoundationsDesignPatternsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityLikedInFoundationsDesignPatternsBinding = DataBindingUtil.setContentView(this, R.layout.activity_liked_in_foundations_design_patterns)

        binding.buttonBasicCameraApp.setOnClickListener {
            val phoneCamera: PhoneCameraApp = BasicCameraApp()
            phoneCamera.performSharing()
            phoneCamera.performSaving()
        }

        binding.buttonCameraPlusApp.setOnClickListener {
            val phoneCamera: PhoneCameraApp = CameraPlusApp()
            phoneCamera.performSharing()
            phoneCamera.performSaving()
        }
    }
}