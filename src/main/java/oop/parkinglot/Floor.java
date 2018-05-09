package oop.parkinglot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oop.parkinglot.spot.ParkingSpot;

/**
* @date	Apr 26, 2018 5:49:30 PM
* @author Darpan Shah
*/

public class Floor {
	List<ParkingSpot> spots;
	
	public Floor(){
		spots = new ArrayList<>();
	}
	
	public void add(ParkingSpot spot){
		if(spots!=null)
			spots.add(spot);
	}
	
	public boolean remove(ParkingSpot spot){
		if(spots!=null)
			return spots.remove(spot);
		return false;
	}
	
//	private SpotIterator iterator;
	
	public Iterator<ParkingSpot> iterator(){
		return spots.iterator();
	}
	
//	private class SpotIterator implements Iterator{
//		
//		@Override
//		public boolean hasNext() {
//			return spots.iterator().hasNext();
//		}
//
//		@Override
//		public Object next() {
//			return spots.iterator().next();
//		}
//		
//	}
}
