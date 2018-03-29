package common;
/**
* @date	Mar 28, 2018 2:53:20 PM
* @author Darpan Shah
*/

public class BST extends BinaryNode{
	public int data;
	public BST left;
	public BST right;
	public BST parent;
	
	public BST(int data){
		super(data);
		this.data = data;
	}
	
	public static boolean validateBST(BST root){
		if(root==null){
			return true;
		}
		return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	public static boolean validate(BST root, int min, int max){
		if(root==null)
			return true;
		if(!(root.data > min && root.data < max)){
			return false;
		}
		return validate(root.left, min, root.data) && validate(root.right, root.data, max);
	}
	public static BST findNextHighestNode(BST node){
		if(node.right != null){
			return leftMostRightNode(node.right);
		}
		return leftMostParent(node, node);
		
	}
	public static BST leftMostRightNode(BST node){
		if(node.left!=null){
			return leftMostRightNode(node.left);
		}
		return node;
	}
	public static BST leftMostParent(BST node, BST lookingFor){
		if(node.parent==null){
			if(node.data > lookingFor.data)
				return node;
			else
				return lookingFor;
		}
		if(node.data == node.parent.right.data){
			return leftMostParent(node.parent, lookingFor);
		}else{
			return node.parent;
		}
	}
	public static BST findNode(BST root, int lookingFor){
		if(root == null){
			return null;
		}
		if(root.data == lookingFor)
			return root;
		if(root.data > lookingFor)
			return findNode(root.left, lookingFor);
		else
			return findNode(root.right, lookingFor);
		
	}
}
