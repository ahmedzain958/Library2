package com.example.library2.designpatterns.linkedin.observerpattern.weather;

public interface Observer {
	public void update(float temp, float humidity, float pressure);
}
