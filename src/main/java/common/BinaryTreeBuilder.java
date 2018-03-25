package common;

import java.util.HashMap;
import java.util.Scanner;

/**
* @date	Mar 23, 2018 9:22:17 AM
* @author Darpan Shah
*/
public class BinaryTreeBuilder {

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
}
