package Challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 15, 2018 2:25:13 PM
* }
*/
/*
Problem:
=======
Given a string, count number of subsequences of the form a^ib^jc^k, 
i.e., it consists of i ’a’ characters, followed by j ’b’ characters, followed by k ’c’ characters where i >= 1, j >=1 and k >= 1. 

Note: Two subsequences are considered different if the set of array indexes picked for the 2 subsequences are different.

Expected Time Complexity : O(n)

Examples:
Input  : abbc
Output : 3
Subsequences are abc, abc and abbc

Input  : abcabc
Output : 7
Subsequences are abc, abc, abbc, aabc
abcc, abc and abc

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string s.
2
abbc
abcabc

Output:
3
7
*/
public class Challenge3 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); 
		scanner.nextLine();
		while(T > 0){
			String string = scanner.nextLine();
			Graph graph = new Graph<Node>();
			boolean rw = false;
			for(int i=0; i<string.length(); i++){
				String name = String.valueOf(string.charAt(i));
				if("c".equals(name)){
					rw = false;
				}
				graph.addNode(new Node(name, i, rw));
			}
			
			--T;
		}
		scanner.close();
	}
	public static class Node{
		String name;
		int index;
		List<Node> inbound;
		List<Node> outbound;
		boolean isTerminal;
		
		public Node(String name, int index, boolean isTerminal){
			this.name = name;
			this.index = index;
			this.isTerminal = isTerminal;
		}
		
	}
	public static class Graph<V extends Node> {
		Map<String, V> nodes;
		
		public Graph(){
			nodes = new HashMap<String, V>();
		}
		
		public void addNode(V node){
			nodes.put(node.name, node);
		}
		
	}
}
