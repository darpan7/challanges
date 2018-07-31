package challenges.geeksforgeeks;

import java.util.Scanner;

import common.Binary;

/**
* @date	Mar 26, 2018 4:23:49 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Position of rightmost set bit
Write a one line C function to return position of first 1 from right to left, in binary representation of an Integer.
I/P    18,   Binary Representation 010010
O/P   2
I/P    19,   Binary Representation 010011
O/P   1
*/
public class Challenge17 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		
		while(T > 0){
			int n = scanner.nextInt();
			System.out.println(Binary.positionOfBit(n, 1, -1));
			--T;
		}
		scanner.close();
	}

}
