package challenges;

import java.util.Scanner;

import common.LinkedList;

/**
* @date	Mar 21, 2018 10:14:40 AM
* @author Darpan Shah
*/
/*
 Problem:
 =======
 Given only a pointer/reference to a node to be deleted in a singly linked list, how do you delete it?
 You may assume that the node to be deleted is not the last node.
 Input:
 You have to complete a method which takes one argument: pointer/reference to a node to be deleted.  
 There are multiple test cases. For each test case, this method will be called individually.
 Input
	2
	2
	1 2
	1
	4
	10 20 4 30
	20
 Output
	2
	10 4 30 
 */
public class Challenge9 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			LinkedList root = null;
			LinkedList node = null;
			root = scanAllNodes(scanner, node, n, root);
			int del = scanner.nextInt();
			LinkedList delnode = LinkedList.findNode(del, root);
			deleteNode(delnode);
			LinkedList.printLinkedList(root);
			--T;
		}
		scanner.close();
	}
	public static LinkedList scanAllNodes(Scanner scanner, LinkedList node, int n, LinkedList root){
		for(int i=0; i<n; i++){
			LinkedList next = new LinkedList(scanner.nextInt());
			if(node != null){
				node.next = next;
			}else{
				root = next;
			}
			node = next;
		}
		return root;
	}
	
	public static void deleteNode(LinkedList del){
		del.data = del.next.data;
		del.next = del.next.next;
	}

}
