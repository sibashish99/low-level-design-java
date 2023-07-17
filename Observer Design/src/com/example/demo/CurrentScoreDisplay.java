package com.example.demo;

public class CurrentScoreDisplay implements Observer {

	@Override
	public void update(int runs, int wickets, float runRate) {
		// TODO Auto-generated method stub
		System.out.println(
				"Current Score Display: Runs - " + runs + ", Wickets - " + wickets + ", Run Rate - " + runRate);
	}

}
