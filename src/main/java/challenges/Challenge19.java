package challenges;

import java.util.Scanner;

import common.Reader;

/**
* @date	Mar 28, 2018 9:39:27 AM
* @author Darpan Shah
*/
/*
Problem:
=======
A Boolean Matrix Question.
Given a boolean matrix mat[M][N] of size M X N, modify it such that if a matrix cell mat[i][j] is 1 (or true) then make all the cells of ith row and jth column as 1. 
Example 1
The matrix
1 0
0 0
should be changed to following
1 1
1 0
Example 2
The matrix
0 0 0
0 0 1
should be changed to following
0 0 1
1 1 1

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is r and c,r is the number of rows and c is the number of columns.
The second line of each test case contains all the elements of the matrix in a single line separated by a single space.

Output:
Print the modified array.

Constraints:
1 ≤ T ≤ 50
1 ≤ r,c ≤ 20
0 ≤ Elements of matrix ≤ 1

Example:
Input:
3
2 2
1 0 0 0
2 3
0 0 0 0 0 1
3 4
1 0 0 1 0 0 1 0 0 0 0 0
Output:
1 1 1 0
0 0 1 1 1 1
1 1 1 1 1 1 1 1 1 0 1 1
*/
public class Challenge19 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int r = scanner.nextInt();
			int c = scanner.nextInt();
			int[][] matrix = new int[r][c];
			
			Reader.loadMatrix(scanner, matrix, r, c);
			modifyMatrix(matrix, r, c);
			printMatrix(matrix, r, c);
			--T;
		}
		scanner.close();
	}
	public static void printMatrix(int[][] matrix, int r, int c){
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				sb.append(matrix[i][j]); sb.append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString().trim());
	}
	public static void modifyMatrix(int[][] matrix, int r, int c){
		boolean[][] visited = new boolean[r][c];
		initializeMatrix(matrix, visited, r, c);
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				if (matrix[i][j] == 1 && visited[i][j]) {
					updateMatrix(matrix, visited, r, c, i, j);
				}
			}
		}
	}
	public static void updateMatrix(int[][] matrix, boolean[][] visited, int r, int c, int i, int j){
		for(int m=j; m<c; m++){
			matrix[i][m] = 1;
		}
		for(int m=0; m<j; m++){
			matrix[i][m] = 1;
		}
		for(int m=i; m<r; m++){
			matrix[m][j] = 1;
		}
		for(int m=0; m<i; m++){
			matrix[m][j] = 1;
		}
		
	}
	public static void initializeMatrix(int[][] matrix, boolean[][] dp, int r, int c){
		for(int i=0; i<r; i++){
			for(int j=0; j<c; j++){
				dp[i][j] = matrix[i][j]==1?true:false;
			}
		}
	}
}
