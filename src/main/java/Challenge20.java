import java.util.Arrays;
import java.util.Scanner;

import common.Search;

/**
* @date	Mar 28, 2018 10:46:18 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Count number of occurrences (or frequency) in a sorted array
Given a sorted array arr[] and a number x, write a function that counts the occurrences of x in arr[]. Expected time complexity is O(Logn) 
Examples:
  Input: arr[] = {1, 1, 2, 2, 2, 2, 3,},   x = 2
  Output: 4 // x (or 2) occurs 4 times in arr[]
Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and X, N is the size of array.
The second line of each test case contains N input C[i].
Output:
Print the counts the occurrence of X, if zero then print -1.
Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 300
1 ≤ C[i] ≤ 500
Example:
Input:
2
7 2
1 1 2 2 2 2 3
7 4
1 1 2 2 2 2 3
Output:
4
-1
Explanation:
In first test case, 2 occurs 4 times in 1 1 2 2 2 2 3
In second test case, 4 is not present in 1 1 2 2 2 2 3
*/
public class Challenge20 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int x = scanner.nextInt();
			int[] array = new int[n];
			for(int i=0; i<n; i++){
				array[i] = scanner.nextInt();
			}
			int output = Search.occurencesInSortedArray(array, x);
			System.out.println((output==0?-1:output));
			--T;
		}
		scanner.close();

	}

}
