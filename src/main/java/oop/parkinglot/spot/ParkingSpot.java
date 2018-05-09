package oop.parkinglot.spot;

import oop.parkinglot.vehicle.Vehicle;

/**
* @date	Apr 26, 2018 5:37:21 PM
* @author Darpan Shah
*/

public abstract class ParkingSpot {
	public enum SIZE {
		COMPACT, MOTORCYCLE, LARGE;
	}
	protected Vehicle usedBy;
	protected long parkedTime;
	public SIZE size;
	
	public Vehicle getUser(){
		return usedBy;
	}
	public void setUser(Vehicle v){
		this.usedBy = v;
	}
	public void setParkingTime(long timestamp){
		this.parkedTime = timestamp;
	}
	public long parkedTime(){
		return this.parkedTime;
	}
}
