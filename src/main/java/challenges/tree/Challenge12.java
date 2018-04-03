package challenges.tree;

import java.util.Scanner;

import common.BinaryNode;
import common.TreeOperator;
import common.OddEven;

/**
* @date	Mar 23, 2018 9:35:27 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Difference between sums of odd level and even level nodes of a Binary Tree.
Given a a Binary Tree, your task is to complete the function getLevelDiff which  returns the difference between the sum of nodes at odd level and the sum of nodes at even level . 
The function getLevelDiff  takes only one argument  ie the root of the binary tree .
      2
    /   \
   3     5
For the above tree the odd level sum is 2 and even level sum is 8 thus the difference is 2-8=-6

Input:
The task is to complete the method which takes one argument, root of Binary Tree. There are multiple test cases. For each test case, this method will be called individually.

Output:
The function should return an integer denoting the difference between the sum of nodes at odd level and the sum of nodes at even level

Constraints:
1 <=T<= 30
1 <= Number of nodes<= 20

Example:
Input
2
2
1 2 R 1 3 L
4
10 20 L 10 30 R 20 40 L 20 60 R
Output
-4
60
 */
public class Challenge12 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
            BinaryNode root = TreeOperator.createBinaryTree(scanner, n);
            OddEven storage = new OddEven();
            BinaryNode.getLevelDiff(root, 1, storage);
            System.out.println((storage.odd - storage.even));
        	--t;
        }
        scanner.close();
	}

}

