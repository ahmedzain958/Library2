package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.appclasses;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.SaveStrategy;
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.ShareStrategy;
import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.TakeBehavior;

public abstract class PhoneCameraApp {
    TakeBehavior takeBehavior;
    ShareStrategy shareBehavior;
    SaveStrategy saveBehavior;

    abstract void edit();


    public void performSharing() {
        shareBehavior.share();
    }

    public void performSaving() {
        saveBehavior.save();
    }
}
