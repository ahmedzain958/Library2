package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.saving.BasicCameraAppSavingBehavior;
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.sharing.TextSharing;

public class BasicCameraApp extends PhoneCameraApp {
    public BasicCameraApp() {
        shareBehavior = new TextSharing();
        saveBehavior = new BasicCameraAppSavingBehavior();
    }

    @Override
    void edit() {

    }

}
