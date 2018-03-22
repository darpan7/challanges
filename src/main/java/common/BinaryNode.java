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
	
	public static void distanceFromRoot(BinaryNode root, int currentDistance, int lookingFor){
		if(root==null){
			return;
		}
		if(currentDistance == lookingFor){
			System.out.print(root.data + " ");
		}
		++currentDistance;
		
		distanceFromRoot(root.left, currentDistance, lookingFor);
		distanceFromRoot(root.right, currentDistance, lookingFor);
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
