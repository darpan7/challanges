package challenges.geeksforgeeks;

import java.util.Scanner;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 14, 2018 2:42:11 PM
* }
*/
/*
Problem:
=======
Given a positive integer n, count the total number of set bits in binary representation of all numbers from 1 to n.
Examples:
Input: n = 3
Output:  4
Input: n = 6
Output: 9
Input: n = 7
Output: 12
Input: n = 8
Output: 13

Program Input: No of test cases, then following number for each test case
3
15
17
3
Program Output:
32
35
4
 */
public class Challenge2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		
		while(T > 0){
			scanner.nextLine();
			int n = scanner.nextInt();
			int bits = bitsInBinary(n);
			int check = (int) (Math.pow(2, bits) - 1); // 2^bits -1
			boolean isPowerOf2 = isPowerOf2s(check, n, bits);
			if(!isPowerOf2){
				double setBitsInClosest2sPower = (bits - 1) * Math.pow(2, bits - 2); // (bits-1)*2^bits-2
				int previousNumber = (int) (Math.pow(2, bits - 1) - 1); // 2^bits-1 - 1
				int difference = n - previousNumber;
				long total1s = (long) setBitsInClosest2sPower; // minimum set bits.
				boolean isSetBit = false;
				// find no of set bits in difference.
				for (int i = 0; i < bits; i++) {
					int power = (int) Math.pow(2, i);
					int divide = (difference / power);
					int modulo = difference % power;
					if (divide > 0) {
						isSetBit = true;
					}
					if (i == (bits - 1)) {
						total1s += modulo;
					} else if (i == 0) {
						total1s += (difference / 2);
					} else if (isSetBit) {
						int decide = (difference / power);
						int times = (decide / 2) * power;
						int onesForThis2sPower = times + ((decide % 2 == 0) ? 0 : modulo);
						total1s += onesForThis2sPower;
					}

					isSetBit = false;
				}
				p(total1s);
			}
			--T;
		}
		scanner.close();
	}
	public static boolean isPowerOf2s(int check, int n, int bits){
		if(check == n){
			p((long) (bits*Math.pow(2, bits-1)));
			return true;
		}
		return false;
	}
	
	public static int bitsInBinary(int n){
		String binary = Integer.toBinaryString(n);
		return binary.length();
	}
	public static void p(Object o) {
		System.out.println(o.toString());
	}
}
