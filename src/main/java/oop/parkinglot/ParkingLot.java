package oop.parkinglot;

import oop.parkinglot.service.CarSpotFinder;
import oop.parkinglot.service.MotorCycleSpotFinder;
import oop.parkinglot.service.SpotFinder;
import oop.parkinglot.spot.ParkingSpot;
import oop.parkinglot.vehicle.Vehicle;

/**
* @date	Apr 26, 2018 5:54:24 PM
* @author Darpan Shah
*/

public class ParkingLot {
	private static ParkingLot parkinglot;
	Floor[] floors;
	
	public void setFloors(int flr){
		floors = new Floor[flr];
		for(int i=0; i<flr; i++){
			floors[i] = new Floor();
		}
	}
	private ParkingLot(){	}
	
	public void park(Vehicle v){
		switch(v.TYPE){
			case MOTORCYCLE:
				park(v, new MotorCycleSpotFinder());// use finderFactory instead of direct creation.
				break;
			case CAR:
				park(v, new CarSpotFinder());
				break;
			case BUS:
				park(v, new CarSpotFinder());
				break;
		}
	}
	public void park(Vehicle v, SpotFinder finder){
		ParkingSpot spot = findFreeSpot(v, finder);
		if(spot!=null){
			spot.setUser(v);
		}else{
			throw new RuntimeException("No parking slot available!");
		}
	}
	public ParkingSpot findFreeSpot(Vehicle v, SpotFinder finder){
		return finder.findFreeSlot(v, this.floors);
	}
	
	public synchronized static ParkingLot getInstance(){
		if(parkinglot==null)
			parkinglot = new ParkingLot();
		return parkinglot;
	}
}
