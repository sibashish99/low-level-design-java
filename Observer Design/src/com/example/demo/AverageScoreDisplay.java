package com.example.demo;

public class AverageScoreDisplay implements Observer {

	@Override
	public void update(int runs, int wickets, float runRate) {
		// TODO Auto-generated method stub
	        System.out.println("Average Score Display: Average Score - " +  runs / (float) wickets);
	    }

}
