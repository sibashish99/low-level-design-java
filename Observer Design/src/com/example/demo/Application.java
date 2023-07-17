package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CricketData cricketData = new CricketData();

		// Create display elements
		CurrentScoreDisplay currentScoreDisplay = new CurrentScoreDisplay();
		AverageScoreDisplay averageScoreDisplay = new AverageScoreDisplay();

		// Attach display elements to the cricket data
		cricketData.attach(currentScoreDisplay);
		cricketData.attach(averageScoreDisplay);

		// Update the score
		cricketData.setScore(105, 4, 6.25f);

		// Detach a display element
		cricketData.detach(averageScoreDisplay);

		// Update the score again
		cricketData.setScore(150, 3, 7.50f);
	}

}
