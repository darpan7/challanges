package common;

/**
 * @date Apr 17, 2018 12:40:58 PM
 * @author Darpan Shah
 */
class DNode {
	public int data;
	public DNode next;
	public DNode prev;
	
	public DNode(int data){
		this.data = data;
	}
}
public class DoublyLinkedList {
	public DNode head;
	public DNode tail;
	int total = 0;
	
	public DoublyLinkedList(){
		this.head = null;
		this.tail = null;
	}
	
	public void add(int data){
		DNode newnode = new DNode(data);
		if(head==null)
			head = newnode;
		newnode.next = null;
		newnode.prev = tail;
		if(tail!=null)
			tail.next = newnode;
		tail = newnode;
		++total;
	}
	public void rotate(){
		if(head == tail)
			return;
		tail.next = head;
		head.prev = tail;
		tail.prev.next = null;
		DNode previous = tail.prev;
		tail.prev = null;
		head = tail;
		tail = previous;
		//print();
	}
	public void print(){
		DNode node = head;
		StringBuilder sb = new StringBuilder();
		while(node!=null){
			sb.append(node.data); sb.append(" ");
			node = node.next;
		}
		System.out.println(sb.toString().trim());
	}
	public int delete(int index){
		if(head==null || tail == null){
			return -1;
		}
		int del = 0;
		if(head==tail){
			del = head.data;
			head = null;
			tail = null;
		}else if(((total-1) - index) < 0){
			del = head.data;
			head.next.prev = null;
			head = head.next;
		}else if(index == 0){
			del = tail.data;
			tail.prev.next = null;
			tail = tail.prev;
		}else  {
			DNode node = tail;
			while(index-->0){
				node = node.prev;
			}
			del = node.data;
			if(node.prev!=null)
				node.prev.next = node.next;
			node.next.prev = node.prev;
			if(node == head)
				head = head.next;
		}
		--this.total;
		return del;
	}
	
}
