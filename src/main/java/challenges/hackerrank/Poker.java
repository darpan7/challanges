package challenges.hackerrank;

/**
* @date	Aug 23, 2018 1:20:55 PM
* @author Darpan Shah
*/

public class Poker
{

  /*
   * Given a set of 5 playing card identifiers such as 2H, 7C, QS, 10D, 2D;
   * determine if this hand is better than some other hand, according to the rules of poker.
   *
   * Hands will be a string with 5 cards comma separated,
   * each card will have 1-2 digits or JQKA and a suit indicator C,D,S,H (i.e. 10C, KH)
   *
   * Possible Hand Types Below:
   *   Straight flush
   *   Four of a kind
   *   Full house
   *   Flush
   *   Straight
   *   Three of a kind
   *   Two pair
   *   One pair
   *
   * The goal of this is to compare between the hand types.
   * Comparing 2 of the same type (i.e. 2 straights) to determine a winner is outside the scope
   * and will not be tested.
   *
   * Implement PokerHand.isGreaterThan(...) method and return whether or not the first hand wins over the second hand.
   */

   static class PokerHand {

      private String handAsString;
      private Handler handler;

      public PokerHand(String hand) {
         handAsString = hand;
         prepare();
      }
      public void prepare(){
    	  Handler sf = new StraightFlush();
    	  setHeadOfChain(sf);
    	  sf.register(new FourAKind())
    	  	.register(new FullHouse())
    	  	.register(new Flush())
    	  	.register(new Straight())
    	  	.register(new ThreeAKind())
    	  	.register(new TwoPair())
    	  	.register(new OnePair());
      }

      public Boolean isGreaterThan(PokerHand hand2) {
         // This is where you'll implement the poker hand comparison logic
    	 HandType h1 = getPokerHandtype(this.handAsString);
    	 HandType h2 = getPokerHandtype(hand2.handAsString);
    	 return h1.getValue() <= h2.getValue()?true:false;
      }

      @Override
      public String toString() {
         return handAsString;
      }
      
      public HandType getPokerHandtype(String s){
    	  String[] cards = s.split(",");
    	  Handler foundHandler = this.handler.handle(cards);
    	  return foundHandler.getType();
      }
      public void setHeadOfChain(Handler handler){
    	  this.handler = handler;
      }
   }
   
   static interface Handler {
	   
	   public Handler handle(String[] cards);
	   public HandType getType();
	   public Handler register(Handler chain);
	   
   }
   static class StraightFlush implements Handler{
	   private HandType type = HandType.STRAIGHT_FLUSH;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
				// process
				// isit = true; if its actually.
				// return this. if its this type.
				// 
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
	   
   }
   
   static class OnePair implements Handler{
	   private HandType type = HandType.ONE_PAIR;
	   
		@Override
		public Handler handle(String[] cards) {
			return this;
		}
		
		public Handler register(Handler nextChain){
			return null;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   
   static class TwoPair implements Handler{
	   private HandType type = HandType.TWO_PAIR;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
				// process
				// isit = true; if its actually.
				// return this. if its this type.
				// 
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
	   
   }
   
   static class FourAKind implements Handler{
	   private HandType type = HandType.FOUR_A_KIND;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   static class ThreeAKind implements Handler{
	   private HandType type = HandType.THREE_A_KIND;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   static class Flush implements Handler{
	   private HandType type = HandType.FLUSH;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   static class FullHouse implements Handler{
	   private HandType type = HandType.FULL_HOUSE;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   static class Straight implements Handler{
	   private HandType type = HandType.STRAIGHT;
	   private Handler next;
	   
		@Override
		public Handler handle(String[] cards) {
			boolean isit = false;
			for(String s: cards){
			}
			return next.handle(cards);
		}
		
		public Handler register(Handler nextChain){
			this.next = nextChain;
			return this.next;
		}
	
		@Override
		public HandType getType() {
			return this.type;
		}
   }
   static enum HandType {
	   STRAIGHT_FLUSH(1),
	   FOUR_A_KIND(2),
	   FULL_HOUSE(3),
	   FLUSH(4),
	   STRAIGHT(5),
	   THREE_A_KIND(6),
	   TWO_PAIR(7),
	   ONE_PAIR(8);
	   
	   private int value;
	   
	   private HandType(int v){
		   this.value = v;
	   }
	   public int getValue(){
		   return this.value;
	   }
   }

   public static void testHand1IsGreaterThanHand2(String hand1AsString,
                                                  String hand2AsString,
                                                  Boolean expectedResult) {
      PokerHand hand1 = new PokerHand(hand1AsString);
      PokerHand hand2 = new PokerHand(hand2AsString);
      System.out.println("Hand1[" + hand1 + "] > Hand2[" + hand2 + "] \t-- " +
                         "expected: " + expectedResult + ", actual: " + hand1.isGreaterThan(hand2));
   }

   public static void main(String[] args) {
      testHand1IsGreaterThanHand2(
         "8C,9C,10C,JC,QC", // straight flush
         "6S,7H,8D,9H,10D",
         true);

      testHand1IsGreaterThanHand2(
         "4H,4D,4C,4S,JS", //four of a kind
         "6C,6S,KH,AS,AD",
         true);

      testHand1IsGreaterThanHand2(
         "6C,6D,6H,9C,KD",
         "5C,3C,10C,KC,7C", // flush
         false);

      testHand1IsGreaterThanHand2(
         "4H,4D,4C,KC,KD", // full house
         "9D,6S,KH,AS,AD",
         true);

      testHand1IsGreaterThanHand2(
         "6C,6D,6H,9C,KD",
         "2C,3C,4S,5S,6S", // straight
         false);

      testHand1IsGreaterThanHand2(
         "7C,7D,7S,3H,4D", // three of a kind
         "9S,6S,10D,AS,AD",
         true);

      testHand1IsGreaterThanHand2(
         "2S,2D,JH,7S,AC",
         "8C,8H,10S,KH,KS", // two pair
         false);

      testHand1IsGreaterThanHand2(
         "AC,AH,3C,QH,10C", // one pair
         "3S,2D,KH,JS,AD",
         true);
   }
}