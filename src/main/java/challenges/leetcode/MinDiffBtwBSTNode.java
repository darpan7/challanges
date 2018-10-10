package challenges.leetcode;

import java.util.Scanner;
import common.BinaryNode;

/**
* @date	Aug 1, 2018 5:15:05 PM
* @author Darpan Shah
*/

public class MinDiffBtwBSTNode {
	private int min = Integer.MAX_VALUE;
    public int minDiffInBST(BinaryNode root) {
        if(root == null)
            return -1;
        return getMinDiff(root, 0);
    }
    
    public int getMinDiff(BinaryNode root, int parent){
       if(root == null)
           return 0;
       int lhs = -1;
       if(root.left!=null)
           lhs = getMinDiff(root.left, root.data);
       int rhs = -1;
       if(root.right!=null)
           rhs = getMinDiff(root.right, root.data);
       if(lhs == -1 && rhs == -1)
           return root.data;
       int min_lhs = root.data - lhs;
 	   int min_rhs = rhs - root.data;
       if(parent > root.data) {
    	   // root is left side of parent
    	   
       }else {
    	   // root is right side of parent
       }
        return root.data; // storing submission.
    }
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();

			--T;
		}
		scanner.close();
	}

}
