package challenges;
/**
* @date	Aug 15, 2018 3:15:22 PM
* @author Darpan Shah
*/

public class IntLimitIn10 {

	public static void main(String[] args) {
		int power = 1;
		while(Math.pow(10, power) < Integer.MAX_VALUE){
			System.out.println((long)Math.pow(10, power));
			++power;
		}
		System.out.println(Integer.MAX_VALUE);
		System.out.println((long)Math.pow(10, power));
	}

}
