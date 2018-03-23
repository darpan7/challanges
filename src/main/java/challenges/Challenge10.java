package challenges;

import java.util.Scanner;

import common.BinaryNode;
import common.BinaryTreeBuilder;

/**
* @date	Mar 22, 2018 10:40:11 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Write a Program to Find the Maximum Depth or Height of a Tree.
Given a binary tree, find height of it. Height of empty tree is 0 and height of below tree is 3.
       1
    /     \
  10      39
 /
5
Input:
The task is to complete the method which takes one argument, root of Binary Tree. The struct Node has a data part which stores the data, pointer to left child and pointer to right child.
There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return height tree.

Constraints:
1 <=T<= 30
1 <=Number of nodes<= 100
1 <=Data of a node<= 1000

Example:
Input:
2
2
1 2 L 1 3 R
4
10 20 L 10 30 R 20 40 L 20 60 R
Output:
2
3
*/
public class Challenge10 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
            BinaryNode root = BinaryTreeBuilder.createBinaryTree(scanner, n);
            System.out.print(BinaryNode.height(root));
        	--t;
        }
        scanner.close();
	}

}
