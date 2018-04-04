package codejam;

import java.util.Scanner;

/**
* @date	Apr 2, 2018 1:56:48 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Number Guessing
https://codejam.withgoogle.com/2018/challenges/0000000000000130/dashboard
Code Jam ClosestPalindromNumber Session 2018
Input/Output:
1 // test cases
0 // A
10 // B
4 // N (no of tries)
 5 // code output
TOO_SMALL
 8 // code output
TOO_BIG
 6 // code output
CORRECT
*/
public class NumberGuessing {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			long A = scanner.nextLong();
			A += 1;
			long B = scanner.nextLong();
			int N = scanner.nextInt();
			scanner.nextLine();
			int tries = 1;
			String s = "";
			while(tries++ <= N){
				long guessed = guess(A, B);
				System.out.print(guessed);
				s = scanner.nextLine();
				boolean found = false;
				boolean error = false;
				switch(s){
					case "CORRECT":
						found = true;
						break;
					case "TOO_BIG":
						B = guessed - 1;
						break;
					case "TOO_SMALL":
						A = guessed + 1;
						break;
					default:
						error = true;
						break;
				}
				if(found){
					break;
				}
				if(error){
					System.exit(1);
				}
			}
			--T;
		}
		scanner.close();
	}
	public static long guess(long a, long b){
		return (long) (a + b) >>> 1;
	}

}
