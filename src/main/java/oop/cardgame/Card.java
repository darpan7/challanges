package oop.cardgame;
/**
* @date	Apr 16, 2018 11:54:44 AM
* @author Darpan Shah
*/

public class Card {
	protected int faceValue;
	protected CardType type;
	
	public Card(int faceValue, CardType type){
		this.faceValue = faceValue;
		this.type = type;
	}
	public boolean isFaceCard(){
		return this.faceValue>10;
	}
	public boolean isAce(){
		return this.faceValue == 1;
	}
}
