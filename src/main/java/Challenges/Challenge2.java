package Challenges;

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
 */
public class Challenge2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		
		while(T > 0){
			scanner.nextLine();
			int n = scanner.nextInt();
			p(Integer.toBinaryString(n));
			String binary = Integer.toBinaryString(n);
			int bits = binary.length();
			//p("bits " + bits);
			int check = (int) (Math.pow(2, bits)-1);
			if(check == n){
				p(bits*Math.pow(2, bits-1));
			}else{
				//double total1s = bits*Math.pow(2, bits-1);
				double bottomline = (bits-1)*Math.pow(2, bits-2);
				//p("bottom line: " + bottomline);
				int prev = (int) (Math.pow(2, bits-1)-1);
				//p("prev " + prev);
				int diff = n - prev;
				double total1s = bottomline;
				//p("diff " + diff);
				while(diff>1){
					bits = Integer.toBinaryString(diff).length();
					check = (int) (Math.pow(2, bits)-1);
					if(check == diff){
						total1s += (bits*Math.pow(2, bits-1));
						break;
					}
					bottomline = (bits-1)*Math.pow(2, bits-2);
					prev = (int) (Math.pow(2, bits-1)-1);
					diff = diff - prev;
					total1s += bottomline;
				}
				p((total1s+1));
			}
			--T;
		}
		
		
		scanner.close();
	}
	
	public static void p(Object o) {
		System.out.println(o.toString());
	}
}
