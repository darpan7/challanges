package common;

import java.util.concurrent.atomic.AtomicInteger;

/**
* @date	Mar 22, 2018 11:00:38 AM
* @author Darpan Shah
*/
public class BinaryNode {
	public int data;
	public BinaryNode left;
	public BinaryNode right;
	
	public BinaryNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public static int height(BinaryNode root){
		if(root==null){
			return 0;
		}
		return (Math.max(height(root.left), height(root.right)) + 1);
	}
	
	public static void printNodesAtKDistanceFromRoot(BinaryNode root, int currentDistance, int k){
		if(root==null){
			return;
		}
		if(currentDistance == k){
			System.out.print(root.data + " ");
		}
		++currentDistance;
		
		printNodesAtKDistanceFromRoot(root.left, currentDistance, k);
		printNodesAtKDistanceFromRoot(root.right, currentDistance, k);
	}
	
	public static void getLevelDiff(BinaryNode root, int currentLevel, OddEven storage){
		if(root == null){
			return;
		}
		if(currentLevel%2 == 0){
			storage.even += root.data;
		}else{
			storage.odd += root.data;
		}
		getLevelDiff(root.left, currentLevel+1, storage);
		getLevelDiff(root.right, currentLevel+1, storage);
	}
	
	
	public static BinaryNode getBinaryTreeFromPreOrderArray(int[] pre, char[] preLN){
		BinaryNode root = null;
		BinaryNode parent = null;
		AtomicInteger i = new AtomicInteger(0);
		root = rec(pre, preLN, i, root, parent, "left");
		return root;
	}
	public static BinaryNode rec(int[] pre, char[] preLN, AtomicInteger i, BinaryNode root, BinaryNode parent, String side){
		if(i.get()>=pre.length || i.get()==-1)
			return null;
		BinaryNode node = new BinaryNode(pre[i.get()]);
		if(preLN[i.get()] == 'N'){
			if(root==null){
				root = node;
				parent = node;
				i.incrementAndGet();
				rec(pre, preLN, i, root, parent, "left");
				i.incrementAndGet();
				return rec(pre, preLN, i, root, parent, "right");
			}else{
				i.incrementAndGet();
				rec(pre, preLN, i, root, node, "left");
				i.incrementAndGet();
				rec(pre, preLN, i, root, node, "right");
			}
		}
		switch (side) {
		case "left":
			parent.left = node;
			break;
		case "right":
			parent.right = node;
			break;
		}
		return root;

	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + data;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BinaryNode other = (BinaryNode) obj;
		if (data != other.data)
			return false;
		return true;
	}
	
}