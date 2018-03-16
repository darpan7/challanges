package Challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
			Graph<Node> graph = new Graph<Node>();
			boolean rw = false;
			for(int i=0; i<string.length(); i++){
				String name = String.valueOf(string.charAt(i));
				if("c".equals(name)){
					rw = true;
				}else{
					rw = false;
				}
				graph.addNode(new Node(name, i, rw));
			}
			graph.calculate();
			//System.out.println(graph.count);
			--T;
		}
		scanner.close();
	}
	public static class Node{
		String name;
		int index;
		List<Node> inbound;
		boolean isTerminal;
		
		public Node(String name, int index, boolean isTerminal){
			this.name = name;
			this.index = index;
			this.isTerminal = isTerminal;
			this.inbound = new ArrayList<Node>();
		}

		@Override
		public String toString() {
			return "Node [" + name + ":" + index + "]";
		}
		
		
	}
	public static class Graph<V extends Node> {
		Map<String, List<V>> nodes;
		List<V> nodesByIndex;
		List<V> startingNodes;
		List<Integer> As;
		List<Integer> Bs;
		List<Integer> Cs;
		int count;
		
		public Graph(){
			nodes = new HashMap<String, List<V>>();
			startingNodes = new ArrayList<V>();
			initiate();
		}
		public void initiate(){
			nodesByIndex = new ArrayList<V>();
			As = new ArrayList<Integer>();
			Bs = new ArrayList<Integer>();
			Cs = new ArrayList<Integer>();
		}
		public void sort(){
			Collections.sort(As);
			Collections.sort(Bs);
			Collections.sort(Cs);
		}
		public void addNode(V node){
			if(node.isTerminal){
				//System.out.println("Adding null for " + node.name + node.index);
				node.inbound.add(null);
			}
			List<V> typedNodes = nodes.get(node.name);
			nodesByIndex.add(node);
			if(typedNodes==null){
				typedNodes = new ArrayList<V>();
			}
			typedNodes.add(node);
			nodes.put(node.name, typedNodes);
			switch(node.name){
			case "a":
				startingNodes.add(node);
				for(int i=0; i<node.index; i++){
					V prev = nodesByIndex.get(i);
					if(prev.name.equals(node.name)){
						prev.inbound.add(node);
					}
				}
				break;
			case "b":
				//Bs.add(node.index);
				for(int i=0; i<node.index; i++){
					V prev = nodesByIndex.get(i);
					if(prev.name.equals(node.name) || prev.name.equals("a")){
						prev.inbound.add(node);
					}
				}
				break;
			case "c":
				//Cs.add(node.index);
				for(int i=0; i<node.index; i++){
					V prev = nodesByIndex.get(i);
					if(prev.name.equals(node.name) || prev.name.equals("b")){
						prev.inbound.add(node);
					}
				}
				break;
			default:
			}
			//calculate();
		}
		public void rec(List<Node> start, String s, boolean end){
			//System.out.println(start);
			for(Node n: start){
				if(end && n == null){
					System.out.println(s);
					continue;
				}
				//System.out.print("\t" + n.name + n.index + ": ");
				rec(n.inbound, s+n.name+n.index, n.isTerminal);
			}
			
		}
		public void calculate(){
			for(V start: startingNodes){
				//System.out.print(start.name + start.index + ": " + start.inbound + "\n");
				rec(start.inbound, start.name+start.index, start.isTerminal);
			}
			////////
//			sort();
//			Set<String> set = nodes.keySet();
//			for(String type: set){
//				List<V> list = nodes.get(type);
//				switch(type){
//				case "a":
//					for(V node: list){
//						int id = As.indexOf(node.index);
//						if(id < 0){
//							
//						}else if (id == As.size()-1){
//							
//						}else{
//							for(int i=id+1; i<As.size(); i++){
//								node.inbound.add(node);
//							}
//						}
//					}
//					break;
//				case "b":
//					break;
//				case "c":
//					break;
//				default:
//				}
//			}
		} 
		
	}
}
