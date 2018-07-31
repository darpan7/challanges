package challenges.geeksforgeeks;

import java.util.Scanner;

import common.Reader;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 29, 2018 2:41:26 PM
* }
*/
/*
Problem:
=======
Dynamic Programming | Set 6 (Min Cost Path)
Given a cost matrix cost[][] and a position (m, n) in cost[][], write a function that returns cost of minimum cost path to reach (m, n) from (0, 0). 
Each cell of the matrix represents a cost to traverse through that cell. 
Total cost of a path to reach (m, n) is sum of all the costs on that path (including both source and destination). 
You can only traverse down, right and diagonally lower cells from a given cell, i.e., from a given cell (i, j), cells (i+1, j), (i, j+1) and (i+1, j+1) can be traversed. 
You may assume that all costs are positive integers.

Input:
The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the order of matrix. Next line contains N*N integers denoting the elements of the matrix in row-major form.

Output:
Output the largest sum of any of the paths starting from any cell of row 0 to any cell of row N-1. Print the output of each test case in a new line.

Constraints:
1<=T<=20
2<=N<=20
1<=Matrix[i][j]<=1000 (for all 1<=i<=N && 1<=j<=N)

Example:
Input:
1
2
348 391 618 193 
Output:
966
*/
public class Challenge23 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int[][] matrix  = new int[n][n];
			Reader.loadMatrix(scanner, matrix, n, n);
			int mintSum = minPathFrom00ToMN(matrix, 0, 0);
			int largestSum = maxPathFromTopToBottom(matrix);
			System.out.println(mintSum); // minimum cost path to reach (m, n) from (0, 0).
			System.out.println(largestSum); // largest sum of any of the paths starting from any cell of row 0 to any cell of row N-1
			--T;
		}
		scanner.close();
	}
	public static int minPathFrom00ToMN(int[][] matrix, int i, int j){
		int totalsum = Integer.MAX_VALUE;
		int n = matrix.length;
		if(i>=n || j>=n){
			return totalsum;
		}
		if(i+1 == (n-1) && j==(n-1))
			return matrix[i][j] + matrix[i+1][j];
		if(i == (n-1) && (j+1)==(n-1))
			return matrix[i][j] + matrix[i][j+1];
		if((i+1) == (n-1) && (j+1)==(n-1))
			return matrix[i][j] + matrix[i+1][j+1];
		return matrix[i][j] + Math.min(minPathFrom00ToMN(matrix, i+1, j), Math.min(minPathFrom00ToMN(matrix, i, j+1), minPathFrom00ToMN(matrix, i+1, j+1)));
	}
	public static int maxPathToBottom(int[][] matrix, int i, int j){
		int totalsum = 0;
		int n = matrix.length;
		if(i>=n || j>=n){
			return totalsum;
		}
		if(i==(n-1))
			return matrix[i][j];
		return matrix[i][j] + Math.max(maxPathToBottom(matrix, i+1, j), Math.max(maxPathToBottom(matrix, i, j+1), maxPathToBottom(matrix, i+1, j+1)));
	}
	public static int maxPathFromTopToBottom(int[][] matrix){
		
		int n = matrix.length;
		int largest = Integer.MIN_VALUE;
		for(int j=0; j<n; j++){
			largest = Math.max(largest, maxPathToBottom(matrix, 0, j));
		}
		return largest;
	}
}
