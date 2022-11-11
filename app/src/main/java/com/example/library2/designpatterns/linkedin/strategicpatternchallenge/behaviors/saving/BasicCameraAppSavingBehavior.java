package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.saving;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.SaveStrategy;

public class BasicCameraAppSavingBehavior implements SaveStrategy {

    @Override
    public void save() {
        System.out.println("--Saving from BasicCameraAppSaveBehavior");
    }
}
