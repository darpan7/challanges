package challenges.tree;

import java.util.Scanner;

import common.BinaryNode;
import common.TreeOperator;

/**
* @date	Mar 23, 2018 11:33:58 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Construct a special tree from given preorder traversal.
Given an array ‘pre[]’ that represents Preorder traversal of a spacial binary tree where every node has either 0 or 2 children. 
One more array ‘preLN[]’ is given which has only two possible values ‘L’ and ‘N’. 
The value ‘L’ in ‘preLN[]’ indicates that the corresponding node in Binary Tree is a leaf node and value ‘N’ indicates that the corresponding node is non-leaf node. 
Write a function to construct the tree from the given two arrays.
Example: 
Input:  pre[] = {10, 30, 20, 5, 15},  preLN[] = {'N', 'N', 'L', 'L', 'L'}
Output: Root of following tree
          10
         /  \
        30   15
       /  \
      20   5
1
5
10 30 20 5 15
N N L L L
 */
public class Challenge13 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
        	int[] pre = new int[n];
        	loadValues(scanner, pre);
        	char[] preLN = new char[n];
        	loadValues(scanner, preLN);
            BinaryNode root = BinaryNode.getBinaryTreeFromPreOrderArray(pre, preLN);
            TreeOperator.printBinaryTree("Pre", root);
        	--t;
        }
        scanner.close();

	}
	
	public static void loadValues(Scanner scanner, int[] pre){
		int n = pre.length;
		int i=0;
		while(n>0){
			pre[i++] = scanner.nextInt();
			--n;
		}
	}
	
	public static void loadValues(Scanner scanner, char[] preLN){
		int n = preLN.length;
		int i=0;
		while(n>0){
			preLN[i++] = scanner.next().charAt(0);
			--n;
		}
	}
}
