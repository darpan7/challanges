package common;

/**
* @date	Mar 22, 2018 10:55:44 AM
* @author Darpan Shah
*/
public class LinkedList {
	public int data;
	public LinkedList next;
	
	public LinkedList(int data){
		this.data = data;
		this.next = null;
	}
	public LinkedList(){
		this(0);
	}
	
	public static LinkedList findNode(int lookingFor, LinkedList root){
		LinkedList node = root;
		while(node!=null){
			if(node.data == lookingFor){
				return node;
			}
			node = node.next;
		}
		return null;
	}
	
	public static void printLinkedList(LinkedList root){
		LinkedList node = root;
		StringBuilder sb = new StringBuilder();
		while(node!=null){
			sb.append(node.data); sb.append(" ");
			node = node.next;
		}
		System.out.println(sb.toString().trim());
	}
}
