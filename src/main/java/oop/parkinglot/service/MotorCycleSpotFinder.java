package oop.parkinglot.service;

import java.util.Iterator;

import oop.parkinglot.Floor;
import oop.parkinglot.spot.ParkingSpot;
import oop.parkinglot.vehicle.Vehicle;

/**
* @date	Apr 26, 2018 6:23:56 PM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class MotorCycleSpotFinder implements SpotFinder{
		@Override
		public ParkingSpot findFreeSlot(Vehicle v, Floor[] floors) {
			for(Floor floor: floors){
				Iterator<ParkingSpot> itr = floor.iterator();
				while(itr.hasNext()){
					ParkingSpot sp = itr.next();
					if(sp.getUser()!=null){
						return sp;
					}
				}
			}
			return null;
		}

	}