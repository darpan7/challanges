package challenges.leetcode;

import java.util.Arrays;

/**
* @date	Apr 25, 2018 11:47:46 AM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class MaxXOR {

	public static void main(String[] args) {
		int[] list = new int[]{3,10,5,25,2,8};
		int x = 0;
		for(int d: list){
			x ^= d;
		}
		
		for(int d: list){
			System.out.println((x^d));
			//x = x^d;
		}
		/*for(int i=0; i<list.length; i++){
			for(int j=i; j<list.length; j++){
				System.out.println(list[i] + "^"+ list[j] + "=" + (list[i]^list[j]));
				x ^= (list[i]^list[j]);
			}
		}*/
		System.out.println(x);
	}
}
