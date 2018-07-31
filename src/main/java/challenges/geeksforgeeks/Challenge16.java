package challenges.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
* @date	Mar 26, 2018 3:44:24 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Pair with given product | Set 1 (Find if any pair exists)
Given an array of distinct elements and a number x, find if there is a pair with product equal to x. 
Examples : 
Input : arr[] = {10, 20, 9, 40};
        int x = 400;
Output : Yes

Input : arr[] = {10, 20, 9, 40};
        int x = 190;
Output : No
Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N and a product p.
The second line of each test case contain N number of a[].
Constraints:
1 ≤ T ≤ 100
1 ≤ N ≤ 200
0 ≤ a[] ≤ 1000
1 ≤ pro ≤ 2000000
Example:
Input:
2
5 2
1 2 3 4 5
8 46
5 7 9 22 15 344 92 8
Output:
Yes
No
*/
public class Challenge16 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
        	int p = scanner.nextInt();
        	int[] array = new int[n];
        	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        	boolean found = false;
        	
        	for(int i=0; i<n; i++){
        		array[i] = scanner.nextInt();
        		if(checkPreCondition(array[i], p))
        			continue;
        		if(!found){
        			if(map.get(array[i]) == null){
            			map.put((p/array[i]), array[i]);
            		}else{
            			System.out.println("Yes");
            			found = true;
            		}
        		}
        	}
        	if(!found)
        		System.out.println("No");
        	--t;
        }
        scanner.close();
	}
	public static boolean checkPreCondition(int i, int p){
		if(i>p || i==0)
			return true;
		int x = p/i;
		if((x*i) == p)
			return false;
		return true;
	}

}
