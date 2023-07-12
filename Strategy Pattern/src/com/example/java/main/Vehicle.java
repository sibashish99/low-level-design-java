package com.example.java.main;

import com.example.java.interfaces.DriveStrategy;

public class Vehicle {
     DriveStrategy driveObj;
     
     Vehicle (DriveStrategy driveObj){
    	 this.driveObj=driveObj;
     }
     public void drive() {
    	 driveObj.drive();
     }
}
