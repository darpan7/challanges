package challenges.tree;

import java.util.Scanner;

import common.BinaryNode;
import common.TreeOperator;

/**
* @date	Mar 22, 2018 12:19:08 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Print nodes at k distance from root.
Given a root of a tree, and an integer k. Print all the nodes which are at k distance from root. 
For example, in the below tree, 4, 5 & 8 are at distance 2 from root.
        1
      /   \
     2     3
   /  \    /
  4    5  8 
Input:
2
2 0
1 2 R 1 3 L
4 2
10 20 L 10 30 R 20 40 L 20 60 R
Output:
1
40 60
 */
public class Challenge11 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
            int k = scanner.nextInt();
            BinaryNode root = TreeOperator.createBinaryTree(scanner, n);
            BinaryNode.printNodesAtKDistanceFromRoot(root, 0, k);
        	--t;
        }
        scanner.close();
	}

}
