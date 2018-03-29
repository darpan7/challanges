package common;

import java.util.HashMap;
import java.util.Scanner;

/**
* @date	Mar 23, 2018 9:22:17 AM
* @author Darpan Shah
*/
public class TreeOperator {

	public static BinaryNode createBinaryTree(Scanner scanner, int n) {
		HashMap<Integer, BinaryNode> m = new HashMap<Integer, BinaryNode> ();
        BinaryNode root = null;
        while (n > 0) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            char lr = scanner.next().charAt(0);
            BinaryNode parent = m.get(n1);
            if (parent == null) {
                parent = new BinaryNode(n1);
                m.put(n1, parent);
                if (root == null)
                    root = parent;
            }
            BinaryNode child = new BinaryNode(n2);
            if (lr == 'L')
                parent.left = child;
            else
                parent.right = child;
            m.put(n2, child);
            n--;
        }
        return root;
	}
	public static BinaryNode createBinaryTree(int n) {
        return new BinaryNode(n);
	}
	public static BST createBST(Scanner scanner, int n){
		HashMap<Integer, BST> m = new HashMap<Integer, BST> ();
		BST root = null;
        while (n > 0) {
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            char lr = scanner.next().charAt(0);
            BST parent = m.get(n1);
            if (parent == null) {
                parent = new BST(n1);
                m.put(n1, parent);
                if (root == null){
                    root = parent;
                    root.parent = null;
                }
            }
            BST child = new BST(n2);
            child.parent = parent;
            if (lr == 'L')
                parent.left = child;
            else
                parent.right = child;
            m.put(n2, child);
            n--;
        }
        return root;
	}
	public static void printBinaryTree(String order, BinaryNode root){
		switch(order){
			case "Pre":
				printPreOrder(root);
				break;
			case "In":
				printInOrder(root);
				break;
			case "Post":
				printPostOrder(root);
				break;
		}
	}
	
	private static void printPreOrder(BinaryNode root){
		if(root == null){
			return;
		}
		System.out.print(root.data + " ");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}
	
	private static void printInOrder(BinaryNode root){
		if(root == null){
			return;
		}
		printPreOrder(root.left);
		System.out.print(root.data + " ");
		printPreOrder(root.right);
	}
	private static void printPostOrder(BinaryNode root){
		if(root == null){
			return;
		}
		printPreOrder(root.left);
		printPreOrder(root.right);
		System.out.print(root.data + " ");
	}
	public static void drawTree(BinaryNode root){
		
	}
}
