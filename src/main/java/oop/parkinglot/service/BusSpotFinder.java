package oop.parkinglot.service;

import java.util.Iterator;

import oop.parkinglot.Floor;
import oop.parkinglot.spot.ParkingSpot;
import oop.parkinglot.spot.ParkingSpot.SIZE;
import oop.parkinglot.vehicle.Vehicle;

/**
* @date	Apr 26, 2018 6:56:03 PM
* @author Darpan Shah
*/
public class BusSpotFinder implements SpotFinder{

	@Override
	public ParkingSpot findFreeSlot(Vehicle v, Floor[] floors) {
		for(Floor floor: floors){
			Iterator<ParkingSpot> itr = floor.iterator();
			int count = 0;
			while(itr.hasNext()){
				ParkingSpot sp = itr.next();
				if(sp.getUser()!=null && (sp.size==SIZE.LARGE)){
					++count;
				}
				if(count == 5)
					return sp;
			}
		}
		return null;
	}

}