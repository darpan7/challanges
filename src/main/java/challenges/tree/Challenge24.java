package challenges.tree;

import java.util.Scanner;

import common.BinaryNode;
import common.TreeOperator;

/**
* @date	Apr 3, 2018 10:23:19 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Traverse the border of Binary Tree.
Example:
Input:
3
2
1 2 L 1 3 R
4
10 20 L 10 30 R 20 40 L 20 60 R
10
1 2 L 1 3 R 2 4 L 2 5 R 5 10 L 10 11 R 3 6 L 3 7 R 7 8 L 8 9 R
Output:
2 1 3
40 20 10 30
4 2 1 3 7 8 9
*/
public class Challenge24 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
            BinaryNode root = TreeOperator.createBinaryTree(scanner, n);
            BinaryNode.printBorderOf(root);
			--T;
		}
		scanner.close();

	}

}
