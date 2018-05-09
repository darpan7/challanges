package oop.parkinglot.service;

import oop.parkinglot.Floor;
import oop.parkinglot.spot.ParkingSpot;
import oop.parkinglot.vehicle.Vehicle;

/**
* @date	Apr 26, 2018 6:20:21 PM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public interface SpotFinder {

	public ParkingSpot findFreeSlot(Vehicle v, Floor[] floors);
}
