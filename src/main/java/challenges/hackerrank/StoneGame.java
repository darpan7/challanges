package challenges.hackerrank;

import java.util.Scanner;

/**
* @date	Jul 30, 2018 8:35:12 AM
* @author Darpan Shah
*/

public class StoneGame {

	public static boolean stoneGame(int[] piles){
		
		
		return false;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int[] piles = new int[n];
			for(int i=0; i<n; i++){
				piles[i] = scanner.nextInt();
			}
			System.out.println(stoneGame(piles));
			--T;
		}
		scanner.close();

	}

}
