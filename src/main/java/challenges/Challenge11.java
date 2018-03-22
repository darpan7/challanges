package challenges;

import common.BinaryNode;

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
 */
public class Challenge11 {

	public static void main(String[] args) {
		BinaryNode root = new BinaryNode(1);
		BinaryNode left = new BinaryNode(2);
		left.left = new BinaryNode(4);
		left.right = new BinaryNode(5);
		BinaryNode right = new BinaryNode(3);
		right.left = new BinaryNode(8);
		root.left = left;
		root.right = right;
		
		BinaryNode.distanceFromRoot(root, 0, 2);
	}

}
