package Challenges;

import java.util.Arrays;
import java.util.Scanner;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 13, 2018 4:24:56 PM
* }
*/
/* Problem:
 * =======
Given a sequence of matrices, find the most efficient way to multiply these matrices together. 
The problem is not actually to perform the multiplications, but merely to decide in which order to perform the multiplications.

Input: p[] = {40, 20, 30, 10, 30}   
Output: Optimal parenthesization is  ((A(BC))D)
There are 4 matrices of dimensions 40x20, 
20x30, 30x10 and 10x30. Let the input 4 
matrices be A, B, C and D.  The minimum 
number of multiplications are obtained 
by putting parenthesis in following way
(A(BC))D --> 20*30*10 + 40*20*10 + 40*10*30

Input:
The first line of the input contains an integer T, denoting the number of test cases. 
Then T test case follows. The first line of each test case contains an integer N, denoting the number of elements in the array.
Then next line contains N space separated integers denoting the values of the element in the array.

Output:
For each test case the print the minimum number of operations needed to multiply the chain.

Constraints:
1<=T<=100
2<=N<=27
1<=A[]<=500

Example:
Input:
2
5
1 2 3 4 5
3
3 3 3
Output:
(((AB)C)D)
(AB)

 */

public class Challenge1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T>0) {
			int[] input = readElements(scanner);
			Matrix[] matrices = convertIntoMatrix(input);
			int dotposition = matrices.length-1;
			long min = Integer.MAX_VALUE;
			String orderOfOperation = null;
			p(Arrays.toString(matrices));
			while(dotposition>0) {
//				Matrix result = multiplyMatrix(matrices, 0, dotposition);
				--dotposition;
//				if(result.operations < min) {
//					min = result.operations;
//					orderOfOperation = result.name;
//				}
			}
			System.out.println(orderOfOperation);
			--T;
		}
		scanner.close();
	}
	public static void p(Object o) {
		System.out.println(o.toString());
	}
	public static Matrix multiplyMatrix(Matrix[] matrices, int start, int end) {
		if(start == end || start > end || end > matrices.length) {
			return matrices[end];
		}
		return multiplyMatrix(matrices, start, end-1).dot(multiplyMatrix(matrices, end, end+1));
	}
	
	public static int[] readElements(Scanner scanner) {
		int N = scanner.nextInt();
		int[] array = new int[N];
		int index = 0;
		while(index<N) {
			array[index++] = scanner.nextInt();
		}
		scanner.nextLine();
		return array;
	}
	public static Matrix[] convertIntoMatrix(int[] input) {
		Matrix[] matrices = new Matrix[input.length-1];
		char ascii = 'A';
		for(int i=1; i<input.length; i++) {
			Matrix matrix = new Matrix(String.valueOf(ascii++), input[i-1], input[i]);
			matrices[i-1] = matrix;
		}
		return matrices;
	}
}

class Matrix{
	String name;
	int rows;
	int columns;
	Long operations;
	
	public Matrix(String name, int r, int c) {
		this.name = name;
		this.rows = r;
		this.columns = c;
		this.operations = null;
	}
	public Matrix() {
		
	}
	
	@Override
	public String toString() {
		return "\nMatrix [" + name + ": rows=" + rows + ", columns=" + columns + ", operations=" + operations + "]";
	}
	public Matrix dot(Matrix other) {
		Matrix product = new Matrix();
		product.name = "(" + this.name + other.name + ")";
		product.rows = this.rows;
		product.columns = other.columns;
		
		product.operations = (long)(this.rows * this.columns * other.columns);
		if(this.operations!=null) {
			product.operations += this.operations;
		}
		if(other.operations !=null) {
			product.operations += other.operations;
		}
		return product;
	}
}
