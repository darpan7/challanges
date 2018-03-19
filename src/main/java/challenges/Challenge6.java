package challenges;

import java.util.Scanner;

import common.Reader;

/**
* @date	Mar 19, 2018 1:09:13 PM
* @author Darpan Shah
*/
/*
 Problem:
 =======
 Count all possible paths from top left to bottom right of a mXn matrix.
 The problem is to count all the possible paths from top left to bottom right 
 of a mXn matrix with the constraints that from each cell you can either move only to right or down.
 
 Input: 
	First line consists of T test cases. First line of every test case consists of N and M, denoting the number of rows and number of column respectively.
 Output: 
	Single line output i.e count of all the possible paths from top left to bottom right of a mXn matrix. Since output can be very large number use %10^9+7.
 Constraints:
	1<=T<=100
	1<=N<=100
	1<=M<=100
 Example:
 Input:
 1
 3 3
 Output:
 6
 
*/

public class Challenge6 {
	public static final int modulo = 1000000007;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T>0){
			scanner.nextLine();
			int N = scanner.nextInt();
			int M = scanner.nextInt();
			int[][] matrix = new int[N][M];
			int paths = countPossiblePaths(matrix, N-1, M-1);
			System.out.println(paths);
			--T;
		}
		scanner.close();
	}
	public static int countPossiblePaths(int[][] matrix, int N, int M){
		if(N == 0 && M == 0){
			return 1;
		}
		// horizontal bottom line with 1: as there is only one possible path to go right side.
		for(int j=M-1; j>=0; j--){
			matrix[N][j] = 1;
		}
		
		// vertical rightmost line with 1: as there is only one possible path to go down.
		for(int i=N-1; i>=0; i--){
			matrix[i][M] = 1;
		}
		
		// rest of cells: summation of its children`s paths. [right + down]
		for(int i=N-1; i>=0; i--){
			for(int j=M-1; j>=0; j--){
				matrix[i][j] = matrix[i][j+1]%modulo + matrix[i+1][j]%modulo;
			}
		}
		return (int) (matrix[0][0]%(modulo));
	}
}
