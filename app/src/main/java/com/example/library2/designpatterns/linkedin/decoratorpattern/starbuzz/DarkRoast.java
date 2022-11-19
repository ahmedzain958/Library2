package com.example.library2.designpatterns.linkedin.decoratorpattern.starbuzz;

public class DarkRoast extends Beverage {
	public DarkRoast() {
		description = "Dark Roast Coffee";
	}

	public double cost() {
		return .99;
	}
}

