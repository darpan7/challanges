package challenges;

import java.util.Scanner;

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
			Node root = null;
			Node node = null;
			root = scanAllNodes(scanner, node, n, root);
			int del = scanner.nextInt();
			Node delnode = findNode(del, root);
			deleteNode(delnode);
			printNode(root);
			--T;
		}
		scanner.close();
	}
	public static Node scanAllNodes(Scanner scanner, Node node, int n, Node root){
		for(int i=0; i<n; i++){
			Node next = new Node(scanner.nextInt());
			if(node != null){
				node.next = next;
			}else{
				root = next;
			}
			node = next;
		}
		return root;
	}
	public static Node findNode(int del, Node root){
		Node node = root;
		while(node!=null){
			if(node.data == del){
				return node;
			}
			node = node.next;
		}
		return null;
	}
	public static void printNode(Node root){
		Node node = root;
		StringBuilder sb = new StringBuilder();
		while(node!=null){
			sb.append(node.data); sb.append(" ");
			node = node.next;
		}
		System.out.println("Updated Linked List: " + sb.toString().trim());
	}
	public static void deleteNode(Node del){
		del.data = del.next.data;
		del.next = del.next.next;
	}

}
class Node{
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
		this.next = null;
	}
	Node(){
	}
}
