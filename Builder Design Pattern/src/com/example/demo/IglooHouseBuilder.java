package com.example.demo;

public class IglooHouseBuilder implements HouseBuilder {
	private House house;
	 public IglooHouseBuilder(){
	        this.house = new House();
	    }
	 
	@Override
	public void buildBasement() {
		house.setBasement("Ice Bars");

	}

	@Override
	public void buildStructure() {
		 house.setStructure("Ice Blocks");

	}

	@Override
	public void buildRoof() {
		 house.setRoof("Ice Dome");

	}

	@Override
	public void buildInterior() {
		 house.setInterior("Ice Carvings");

	}

	@Override
	public House getHouse() {
		// TODO Auto-generated method stub
		 return this.house;
	}

}
