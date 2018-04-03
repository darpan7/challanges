package challenges.tree;

import java.util.Scanner;

import common.BinaryNode;
import common.TreeOperator;

/**
* @date	Mar 26, 2018 11:29:13 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Tree Isomorphism Problem.
Write a function to detect if two trees are isomorphic. 
Two trees are called isomorphic if one of them can be obtained from other by a series of flips, i.e. by swapping left and right children of a number of nodes.
Any number of nodes at any level can have their children swapped. Two empty trees are isomorphic.

Input:
First line consists of T test cases. First line of every test case consists of N, denoting number of Node in tree. 
Second and third line of every test case consists of N, nodes of binary tree.
Output:
Single line output, return the boolean value true if "Yes" else "No".
Constraints:
1<=T<=100
1<=N<=100
Example:
Input:
2
3
1 2 L 1 3 R 2 4 L
1 3 L 1 2 R 3 4 R
3
1 2 L 1 3 R 2 4 L
1 3 L 1 2 R 2 4 R
Output:
No
Yes
*/
public class Challenge14 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
            BinaryNode rootA = TreeOperator.createBinaryTree(scanner, n);
            BinaryNode rootB = TreeOperator.createBinaryTree(scanner, n);
            System.out.println((areTheyIsomorphic(rootA, rootB))?"Yes":"No");
        	--t;
        }
        scanner.close();
	}
	public static boolean areTheyIsomorphic(BinaryNode rootA, BinaryNode rootB){
		if(rootA == null && rootB == null)
			return true;
		if(rootA == null || rootB == null)
			return false;
		if(rootA.data != rootB.data){
			return false;
		}
		return areTheyIsomorphic(rootA.left, rootB.left) && areTheyIsomorphic(rootA.right, rootB.right) 
				|| (areTheyIsomorphic(rootA.left, rootB.right) && areTheyIsomorphic(rootA.right, rootB.left));
	}
}
