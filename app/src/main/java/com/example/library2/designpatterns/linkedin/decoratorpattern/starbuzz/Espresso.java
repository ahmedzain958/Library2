package com.example.library2.designpatterns.linkedin.decoratorpattern.starbuzz;

public class Espresso extends Beverage {

	public Espresso() {
		description = "Espresso";
	}

	public double cost() {
		return 1.99;
	}
}

