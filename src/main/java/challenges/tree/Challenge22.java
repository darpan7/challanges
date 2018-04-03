package challenges.tree;

import java.util.Scanner;

import common.BST;
import common.TreeOperator;

/**
* @date	Mar 28, 2018 2:46:03 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Given a BST node, find the next highest node in O(log(n)) time.
Input:
First line consists of T test cases. First line of every test case consists of N, denoting number of Node in tree, and K, denoting number of node. 
Second and third line of every test case consists of N, nodes of binary tree.
Output:
Single line output, return the next highest node after K.
Input:
3
2 6
5 6 R 5 3 L
4 25
20 10 L 10 4 L 10 15 R 20 25 R
4 15
20 10 L 10 4 L 10 15 R 15 19 R
Output:
6
25
19
*/
public class Challenge22 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			BST root = TreeOperator.createBST(scanner, n);
			BST lookingFor = BST.findNode(root, k);
			System.out.println(BST.findNextHighestNode(lookingFor).data);
			--T;
		}
		scanner.close();

	}

}
