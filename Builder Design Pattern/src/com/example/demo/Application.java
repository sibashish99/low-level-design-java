package com.example.demo;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HouseBuilder iglooBuilder = new IglooHouseBuilder();
        CivilEngineer engineer = new CivilEngineer(iglooBuilder);
  
        engineer.constructHouse();
  
        House house = engineer.getHouse();
  
        System.out.println("Builder constructed: "+ house);
	}

}
