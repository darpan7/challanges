package common;
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
}
