package com.example.java.main;

import com.example.java.interfaces.DriveStrategy;
import com.example.java.interfaces.NormalDrive;

public class GoodVehicle extends Vehicle {

	GoodVehicle(DriveStrategy driveObj) {
		super(new NormalDrive());
		// TODO Auto-generated constructor stub
	}

	public GoodVehicle() {
		// TODO Auto-generated constructor stub
		super(new NormalDrive());
	}
    
}
