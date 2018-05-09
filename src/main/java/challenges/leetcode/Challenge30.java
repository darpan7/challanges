package challenges.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import common.BinaryNode;

/**
* @date	Apr 19, 2018 10:42:23 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Binary Tree Inorder Traversal
Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]

Follow up: Recursive solution is trivial, could you do it iteratively?
*/
public class Challenge30 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			--T;
		}
		scanner.close();
	}
	public List<Integer> inorderTraversal(BinaryNode root) {
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)
            return list;
        if(root.left==null && root.right==null){
            list.add(root.data);
            return list;
        }
        Stack<BinaryNode> stack = new Stack<BinaryNode>();
        
        while(root!=null){
            if(root.left!=null){
                BinaryNode node = root;
                stack.push(node);
                root = root.left;
            }else{
                list.add(root.data);
                if(root.right==null){
                    root = (stack.isEmpty())?null:stack.pop();
                    if(root!=null) root.left = null;
                }else{
                    root = root.right;
                }
            }
        }
        return list;
    }

}
