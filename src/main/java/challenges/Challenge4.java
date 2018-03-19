package challenges;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
* @date	Mar 16, 2018 1:05:39 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Given an array of integers, replace every element with the next greatest element (greatest element on the right side) in the array. 
Since there is no element next to the last element, replace it with -1.
Input:
	The first line of input contains an integer T denoting the number of test cases.
	The first line of each test case is N,N is the size of array.
	The second line of each test case contains N input A[i].
Output:
	Print the modified array.
Constraints:
	1 ≤ T ≤ 50
	1 ≤ N ≤ 100
	1 ≤ A[i] ≤ 1000

Example:
Input:
2
6
16 17 4 3 5 2
4
2 3 1 9
Output:
17 5 5 5 2 -1
9 9 9 -1

 */
public class Challenge4 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		
		while(T > 0){
			scanner.nextLine();
			int N = scanner.nextInt();
			scanner.nextLine();
			Stack<Element> stackOfGreatest = new Stack<Element>();
			int[] array = new int[N];
			int[] copy = new int[N];
			//optimized solution 1
			for(int i=0; i<N; i++){
				int value = scanner.nextInt();
				array[i] = value;
				copy[i] = value;
			}
			optimizedSolution(array);
			
			// solution 2.
			for(int i=0; i<N; i++){
				calculateStack(copy[i], i, stackOfGreatest);
			}
			Stack<Element> reverseStack = reverseStack(stackOfGreatest);
			replaceWithNextGreatestElement(reverseStack, copy);
			System.out.print("Output: ");
			printArray(copy);
			--T;
		}
		scanner.close();
	}
	public static void optimizedSolution(int[] array){
		int nextGreatest = array[array.length-1];
		array[array.length-1] = -1;
		for(int i=array.length-2; i>=0; i--){
			if(array[i] >= nextGreatest){
				int current = array[i];
				array[i] = nextGreatest;
				nextGreatest = current;
			}else{
				array[i] = nextGreatest;
			}
		}
		System.out.print("Output Using optimized Method: ");
		printArray(array);
	}
	public static void printArray(int[] array){
		String string = Arrays.toString(array);
		string = string.substring(1, string.length()-1);
		System.out.println(string.replaceAll(",", ""));
	}
	public static void replaceWithNextGreatestElement(Stack<Element> stack, int[] array){
		int offset = 0;
		while(!stack.isEmpty()){
			Element element = stack.pop();
			int value = element.value;
			int threshold = element.index;
			for(int i=offset; i<threshold; i++){
				array[i] = value;
			}
			offset = threshold;
		}
		array[array.length-1] = -1;
	}
	public static Stack<Element> reverseStack(Stack<Element> stackOfGreatest){
		Stack<Element> reverse = new Stack<Element>();
		while(!stackOfGreatest.isEmpty()){
			reverse.push(stackOfGreatest.pop());
		}
		return reverse;
	}
	public static void calculateStack(int value, int i, Stack<Element> stackOfGreatest){
		if(stackOfGreatest.empty()){
			stackOfGreatest.push(new Element(value, i));
		}else{
			while(value > stackOfGreatest.peek().value){
				stackOfGreatest.pop();
				if(stackOfGreatest.empty()){
					break;
				}
			}
			stackOfGreatest.push(new Element(value, i));
		}
		
	}
	public static class Element {
		int value;
		int index;
		
		public Element(int value, int index){
			this.value = value;
			this.index = index;
		}
	}
}
