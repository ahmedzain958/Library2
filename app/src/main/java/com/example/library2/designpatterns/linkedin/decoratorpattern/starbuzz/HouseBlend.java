package com.example.library2.designpatterns.linkedin.decoratorpattern.starbuzz;

public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}

	public double cost() {
		return .89;
	}
}

