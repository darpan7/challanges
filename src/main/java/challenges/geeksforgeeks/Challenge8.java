package challenges.geeksforgeeks;

import java.util.Scanner;

/**
* @date	Mar 20, 2018 3:53:25 PM
* @author Darpan Shah
*/
/*
 Problem:
 =======
 Given a binary string, count number of substrings that start and end with 1.
 Example:
 if the input string is â€œ00100101â€�, then there are three substrings â€œ1001â€�, â€œ100101â€� and â€œ101â€�.
 
 Input:
	The first line of input contains an integer T denoting the number of test cases.
	Each test case consist of an integer 'n' denoting the string length and next line is followed by a binary string .
 Output:
	Print the number of substring starting and ending with 1 in a separate line.
 Constraints:
	1 â‰¤ T â‰¤ 40
	1 â‰¤ |s| â‰¤ 1000
 Example:
 Input:
 1
 4
 1111
 Output:
 6
*/
public class Challenge8 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			scanner.nextLine();
			scanner.nextInt();
			scanner.nextLine();
			String binary = scanner.next();
			int i=binary.indexOf("1", 0);
			if(i == -1){
				System.out.println(0);
			}else{
				int ones = 1;
				int substrings = 0;
				for(i=binary.indexOf("1", i+1); i>=0; i=binary.indexOf("1", i+1)){
					substrings += ones;
					++ones;
				}
				System.out.println(substrings);
			}
			--T;
		}
		scanner.close();
	}

}
