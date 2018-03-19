package challenges;

import java.util.Scanner;

/**
* @date	Mar 16, 2018 4:21:12 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Highest power of 2 less than or equal to given number
Given a number n, find the highest power of 2 that is smaller than or equal to n.
Examples:
Input : n = 10
Output : 8
Input : n = 19
Output : 16
Input : n = 32
Output : 32

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,number of people standing in a queue.
Output:
Print the position(original queue) of that person who is left.
Constraints:
1 ≤ T ≤ 1000
1 ≤ N ≤ 100000000
Example:
Input
1
5
Output
4
 */
public class Challenge5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		
		while(T > 0){
			scanner.nextLine();
			long number = scanner.nextLong();
			int bits = bitsInBinary(number); //Long.toBinaryString(number).length(); //(int) (Math.log(number)/Math.log(2));
			long highestPower = (long)Math.pow(2, bits);
			System.out.println(highestPower);
			--T;
		}
		scanner.close();
	}
	public static int bitsInBinary(long number){
		int bits = 0;
		while(number > 0){
			++bits;
			number = number>>1;
		}
		return bits-1;
	}

}
