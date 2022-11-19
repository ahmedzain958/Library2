package com.example.library2.designpatterns.linkedin.decoratorpattern.starbuzz;

public abstract class Beverage {
	String description = "Unknown Beverage";

	public String getDescription() {
		return description;
	}

	public abstract double cost();
}
