package oop.parkinglot.vehicle;
/**
* @date	Apr 26, 2018 5:22:09 PM
* @author Darpan Shah
*/
public abstract class Vehicle {
	public enum V_TYPE {
		MOTORCYCLE, CAR, BUS;
	}
	protected String licensePlate;
	protected String vinNumber;
	protected String make;
	protected String model;
	protected int year;
	public V_TYPE TYPE;
}
