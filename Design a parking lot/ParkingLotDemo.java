/***********************************
*  Design a parking lot in java    *
***********************************/
/**
Constraints and assumptions
>What types of vehicles should we support?
 - Motorcycle, Car, Bus
>Does each vehicle type take up a different amount of parking spots?
 -Yes
 -Motorcycle spot -> Motorcycle
 -Compact spot -> Motorcycle, Car
 -Large spot -> Motorcycle, Car
 -Bus can park if we have 5 consecutive "large" spots
>Does the parking lot have multiple levels?
 -Yes


*/

import java.util.*;

/*The VehicleType enum: This enum defines the different types of vehicles supported in the parking lot, namely MOTORCYCLE, CAR, and BUS.*/
enum VehicleType{
	MOTORCYCLE,
	CAR,
	BUS
}

/*The Vehicle abstract class: This class represents a generic vehicle and contains properties such as the license plate and vehicle type. It serves as the base class for specific vehicle classes like Motorcycle, Car, and Bus.*/

abstract class Vehicle{
	private String licensePlate;
	private VehicleType type;
	
	public Vehicle(String licensePlate,VehicleType type){
		this.licensePlate=licensePlate;
		this.type=type;
	}
	
	public String getLicensePlate(){
		return licensePlate;
	}
	
	public VehicleType getType(){
		return type;
	}
	
}

/*The concrete vehicle classes (Motorcycle, Car, Bus): These classes extend the Vehicle class and provide specific implementations. They are used to create instances of actual vehicles with their respective license plates and types. */
class Motorcycle extends Vehicle{
	public Motorcycle(String licensePlate){
		super(licensePlate,VehicleType.MOTORCYCLE);
	}
}

class Car extends Vehicle{
	public Car(String licensePlate){
		super(licensePlate,VehicleType.CAR);
	}
}
class Bus extends Vehicle{
	public Bus(String licensePlate){
		super(licensePlate,VehicleType.BUS);
	}
}

/*
The ParkingSpot class represents an individual parking spot and stores information about its number and the vehicle parked in it (if any).
*/

class ParkingSpot{
	private String number;
	private Vehicle vehicle;
	
	public ParkingSpot(String number){
		this.number=number;
		this.vehicle=null;
	}
	
	public String getNumber(){
		return number;
	}
	
	public String getVehicle(){
		return vehicle;
	}
	
	public void parkVehicle(Vehicle vehicle){
		this.vehicle=vehicle;
	}
	
	public void removevehicle(){
		this.vehicle=null;
	}
}

/*
The ParkingLot class: This class represents the parking lot itself. 
It contains a list of lists (levels) to represent multiple levels of the parking lot.
Each level is a list of ParkingSpot objects

*/

class ParkingLot {
    private List<List<ParkingSpot>> levels;


    //The constructor of the ParkingLot class takes parameters to specify the number of levels and the number of spots for each type (motorcycle, compact, and large).
    public ParkingLot(int numLevels, int numMotorcycleSpots, int numCompactSpots, int numLargeSpots) {
        levels = new ArrayList<>();

        // Create parking spots for each level
        for (int level = 0; level < numLevels; level++) {
            List<ParkingSpot> spots = new ArrayList<>();

            // Add motorcycle spots
            for (int i = 0; i < numMotorcycleSpots; i++) {
                spots.add(new ParkingSpot("M" + level + "-" + i));
            }

            // Add compact spots
            for (int i = 0; i < numCompactSpots; i++) {
                spots.add(new ParkingSpot("C" + level + "-" + i));
            }

            // Add large spots
            for (int i = 0; i < numLargeSpots; i++) {
                spots.add(new ParkingSpot("L" + level + "-" + i));
            }

            levels.add(spots);
        }
    }

    // Find an available spot for a given vehicle
    private ParkingSpot findAvailableSpot(Vehicle vehicle) {
        VehicleType type = vehicle.getType();

        // Search for a spot based on vehicle type
        for (List<ParkingSpot> spots : levels) {
            for (ParkingSpot spot : spots) {
                if (type == VehicleType.MOTORCYCLE && spot.getVehicle() == null) {
                    return spot;
                } else if (type == VehicleType.CAR && (spot.getVehicle() == null || spot.getVehicle().getType() == VehicleType.MOTORCYCLE)) {
                    return spot;
                } else if (type == VehicleType.BUS && isBusSpotAvailable(spots, spot)) {
                    return spot;
                }
            }
        }

        return null; // No available spot found
    }

    // Check if consecutive large spots are available for a bus
    private boolean isBusSpotAvailable(List<ParkingSpot> spots, ParkingSpot startSpot) {
        int numLargeSpots = 0;
        int startIndex = spots.indexOf(startSpot);

        for (int i = startIndex; i < spots.size(); i++) {
            ParkingSpot spot = spots.get(i);
            if (spot.getVehicle() != null) {
                break; // Spot is occupied, so bus cannot fit
            }

            numLargeSpots++;
            if (numLargeSpots == 5) {
                return true; // Bus can fit
            }
        }

        return false;
    }

    // Park a vehicle in the parking lot
    public boolean parkVehicle(Vehicle vehicle) {
        ParkingSpot spot = findAvailableSpot(vehicle);

        if (spot != null) {
            spot.parkVehicle(vehicle);
            return true;
        }

        return false; // No available spot found
    }

    // Remove a vehicle from the parking lot
    public void removeVehicle(Vehicle vehicle) {
        for (List<ParkingSpot> spots : levels) {
            for (ParkingSpot spot : spots) {
                if (spot.getVehicle() == vehicle) {
                    spot.removeVehicle();
                    return;
                }
            }
        }
    }
}


public class ParkingLotDemo {
    public static void main(String[] args) {
         ParkingLot parkingLot = new ParkingLot(2, 10, 20, 30);

      
        Vehicle motorcycle1 = new Motorcycle("ABC123");
        Vehicle motorcycle2 = new Motorcycle("DEF456");
        Vehicle car1 = new Car("GHI789");
        Vehicle bus1 = new Bus("JKL012");

       
        boolean parkedMotorcycle1 = parkingLot.parkVehicle(motorcycle1);
        boolean parkedMotorcycle2 = parkingLot.parkVehicle(motorcycle2);
        boolean parkedCar1 = parkingLot.parkVehicle(car1);
        boolean parkedBus1 = parkingLot.parkVehicle(bus1);

        System.out.println("Motorcycle 1 parked: " + parkedMotorcycle1);
        System.out.println("Motorcycle 2 parked: " + parkedMotorcycle2);
        System.out.println("Car 1 parked: " + parkedCar1);
        System.out.println("Bus 1 parked: " + parkedBus1);

       
        parkingLot.removeVehicle(motorcycle1);

        
        boolean parkedMotorcycle3 = parkingLot.parkVehicle(new Motorcycle("MNO345"));
        System.out.println("Motorcycle 3 parked: " + parkedMotorcycle3);
    }
}