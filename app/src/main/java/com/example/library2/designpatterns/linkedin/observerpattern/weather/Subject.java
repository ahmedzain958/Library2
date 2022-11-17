package com.example.library2.designpatterns.linkedin.observerpattern.weather;

public interface Subject {
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers();
}
