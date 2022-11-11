package com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.sharing;

import com.example.library2.designpatterns.linkedin.strategicpatternchallenge.behaviors.interfaces.ShareStrategy;

public class EmailSharing implements ShareStrategy {
    @Override
    public void share() {
        System.out.println("Email Sharing");
    }
}
