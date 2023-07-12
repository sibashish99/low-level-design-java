package com.example.java.main;

import com.example.java.interfaces.DriveStrategy;
import com.example.java.interfaces.SportsDriveStrategy;

public class SportsDrive extends Vehicle{

	SportsDrive(DriveStrategy driveObj) {
		super(new SportsDriveStrategy());
		// TODO Auto-generated constructor stub
	}

	public SportsDrive() {
		// TODO Auto-generated constructor stub
		super(new SportsDriveStrategy());
	}
   
}
