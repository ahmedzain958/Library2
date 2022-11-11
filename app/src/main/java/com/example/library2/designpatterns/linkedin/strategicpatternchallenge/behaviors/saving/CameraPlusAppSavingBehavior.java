package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.saving;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.SaveStrategy;

public class CameraPlusAppSavingBehavior implements SaveStrategy {

    @Override
    public void save() {
        System.out.println("--Saving from CameraPlusAppSaveBehavior");
    }
}
