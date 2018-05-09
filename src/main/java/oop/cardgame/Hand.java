package oop.cardgame;

import java.util.ArrayList;
import java.util.List;

/**
* @date	Apr 16, 2018 11:59:50 AM
* @author Darpan Shah
*/

public class Hand<T extends Card> {
	List<T> myCards;
	
	public Hand(int howmany){
		myCards = new ArrayList<T>(howmany);
	}
	
	public void addCard(T card){
		myCards.add(card);
	}
	
	public boolean removeCard(T remove){
		return myCards.remove(remove);
	}
}
