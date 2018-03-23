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