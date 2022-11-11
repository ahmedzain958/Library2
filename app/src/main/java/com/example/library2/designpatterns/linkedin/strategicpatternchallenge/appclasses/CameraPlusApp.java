package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.saving.CameraPlusAppSavingBehavior;
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.sharing.EmailSharing;

public class CameraPlusApp extends PhoneCameraApp {

    public CameraPlusApp() {
        shareBehavior = new EmailSharing();
        saveBehavior = new CameraPlusAppSavingBehavior();
    }

    @Override
    void edit() {

    }
}
