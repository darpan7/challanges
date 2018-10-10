package common;
/**
* @date	Aug 31, 2018 2:13:21 PM
* @author Darpan Shah
*/
public class Maths {
	
	/*
	 * Euclid`s algorithm to find GCD.
	 */
	public static int GCD(int a, int b){
		if(b == 0)
			return a;
		return GCD(b, a%b);
	}
	
	/*
	 * Common approach.
	 */
	public static int gcd(int a, int b){
		for(int i = Math.min(a, b); i>=1; i--){
			if(a%i==0 && b%i==0)
				return i;
		}
		return 1;
	}
	
	/*
	 * Euclid`s algorithm to find LCD/LCM
	 */
	public static int LCD(int a, int b){
		return (a*b)/GCD(a, b);
	}

}
