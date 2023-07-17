package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class CricketData implements Subject {

	private List<Observer> observers = new ArrayList<>();
	private int runs;
	private int wickets;
	private float runRate;

	public void setScore(int runs, int wickets, float runRate) {
		this.runs = runs;
		this.wickets = wickets;
		this.runRate = runRate;
		notifyObservers();
	}

	@Override
	public void attach(Observer observer) {
		// TODO Auto-generated method stub
		observers.add(observer);

	}

	@Override
	public void detach(Observer observer) {
		// TODO Auto-generated method stub
		observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		// TODO Auto-generated method stub
		for (Observer observer : observers) {
            observer.update(runs, wickets, runRate);
        }
	}

}
