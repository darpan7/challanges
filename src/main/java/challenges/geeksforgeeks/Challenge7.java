package challenges.geeksforgeeks;

import java.util.Scanner;

/**
* @date	Mar 19, 2018 3:54:40 PM
* @author Darpan Shah
*/

/*
 Problem:
 =======
 Find a pair with maximum product in array of Integers.
 Given an array with both +ive and -ive integers, return a pair with highest product.
 Examples: 
 Input: arr[] = {1, 4, 3, 6, 7, 0}  
 Output: {6,7}  

 Input: arr[] = {-1, -3, -4, 2, 0, -5} 
 Output: {-4,-5} 
 
 
 */
public class Challenge7 {
	static int max1 = 0; static int max2 = 0; static int max3 = 0;
	static int index1 = -1; static int index2 = -1; static int index3 = -1;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			scanner.nextLine();
			int n = scanner.nextInt();
			scanner.nextLine();
			int[] array = new int[n];
			
			boolean first = true;
			for(int i=0; i<n; i++){
				array[i] = scanner.nextInt();
				if(first){
					int x = Math.abs(array[i]);
					max2 = x; index2 = i;
					max3 = x; index3 = i;
					max1 = x; index1 = i;
					first = false;
				}else{
					checkAndTransfer(Math.abs(array[i]), i);
				}
			}
			System.out.println(choosePair(array));
			System.out.println(array[index1] + ", " + array[index2] + ", " + array[index3]);
			--T;
		}
		scanner.close();
	}
	public static int choosePair(int[] array){
		return Math.max(array[index1]*array[index2], Math.max(array[index1]*array[index3], array[index2]*array[index3]));
	}
	public static void checkAndTransfer(int value, int i){
		if(value > max1){
			max3 = max2; index3 = index2;
			max2 = max1; index2 = index1;
			max1 = Math.abs(value); index1 = i;
		}else if(value > max2){
			max3 = max2; index3 = index2;
			max2 = Math.abs(value); index2 = i;
		}else if(value > max3){
			max3 = Math.abs(value); index3 = i;
		}
	}

}
