package challenges.geeksforgeeks;

import java.util.HashMap;
import java.util.Map;
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
	private static Map<String, Matrix> savedMatrices = new HashMap<String, Matrix>();
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while(T>0) {
			savedMatrices.clear();
			int[] input = readElements(scanner);
			Matrix[] matrices = convertIntoMatrix(input);
			int dotposition = matrices.length-1;
			long min = Integer.MAX_VALUE;
			String orderOfOperation = null;
			while(dotposition>0) {
				Matrix left = multiplyMatrix(matrices, dotposition-1, 0, dotposition-1);
				Matrix right = multiplyMatrix(matrices, dotposition, dotposition, matrices.length-1);
				Matrix result = left.dot(right);
				if(result.operations < min) {
					min = result.operations;
					orderOfOperation = result.name;
				}
				--dotposition;
			}
			p(orderOfOperation);
			--T;
		}
		scanner.close();
	}
	public static String getKey(Matrix[] matrices, int start, int end){
		if(start > end){
			return null;
		}
		StringBuilder sb = new StringBuilder();
		for(int i=start; i<=end; i++){
			sb.append(matrices[i].name);
		}
		return sb.toString();
	}
	public static Matrix multiplyMatrix(Matrix[] matrices, int dotposition, int start, int end) {
		String name = getKey(matrices, start, end);
		if(savedMatrices.get(name)!= null){
			return savedMatrices.get(name);
		}
		if(start >= end || dotposition == 0){
			return matrices[dotposition];
		}
		Matrix result = null;
		for(int i=end; i>start; i--){
			Matrix left = multiplyMatrix(matrices, i-1, start, i-1);
			Matrix right = multiplyMatrix(matrices, i, i, end);
			Matrix dot = left.dot(right);
			if(result == null || result.operations == null || result.operations > dot.operations){
				result = dot;
			}
		}
		if(savedMatrices.get(result.name)==null){
			savedMatrices.put(result.name.replaceAll("[^a-zA-Z]", ""), result);
		}
		return result;
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
	public static void p(Object o) {
		System.out.println(o.toString());
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
