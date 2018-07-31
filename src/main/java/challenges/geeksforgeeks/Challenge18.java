package challenges.geeksforgeeks;

import java.util.Scanner;
import java.util.Set;

import common.StringOperator;

/**
* @date	Mar 27, 2018 2:00:43 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Print all possible strings that can be made by placing spaces.
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. 
Input:  str[] = "ABC"
Output: ABC
        AB C
        A BC
        A B C
Input:
First line contains the test cases T.  1<=T<=10
Each test case have one line string S of characters of length  N.  1<=N<=10
Output:
One line per test case, every string enclosed in ().(See example). Output should be printed in sorted order.
Example:
Input:
2
AB
ABC
Output:
(A B)(AB)
(A B C)(A BC)(AB C)(ABC)
*/
public class Challenge18 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			String s = scanner.next();
			//method 1
			Set<String> strings = StringOperator.permutaionOf(s, " ");
			strings.stream().forEach(str -> System.out.print("("+str+")"));
			System.out.println();
			
			//method 2: faster
			strings = StringOperator.permutationUsingNode(s, ' ');
			strings.stream().forEach(str -> System.out.print("("+str+")"));
			System.out.println();
			--T;
		}
		scanner.close();

	}
}
