package common;
/**
* @date	Apr 5, 2018 11:08:54 AM
* @author Darpan Shah
*/
public class HeapUsingArray {
	private Object[] heap;
	private int index;
	
	public HeapUsingArray(int size){
		this.heap = new Object[size];
		index = 0;
	}
	
	public int indexOfLeftChild(int i){
		validateIndex(i);
		int left = (2*i +1);
		return (left<heap.length)?left:-1;
	}
	
	public int indexOfRightChild(int i){
		validateIndex(i);
		int right = (2*i +2);
		return (right<heap.length)?right:-1;
	}
	public int indexOfParent(int i){
		validateIndex(i);
		int parent = ((i - 1)/2);
		return (parent>=0)?parent:-1;
	}
	
	public void validateIndex(int i){
		if(i<0 || i>=heap.length){
			throw new RuntimeException("Invalid index :" + i);
		}
	}
	
	public void insert(Object data){
		validateIndex(index);
		this.heap[index++] = data;
		heapifyDown();
	}
	public void heapifyDown(){
		for(int i=heap.length-1; i>=0;){
			int parent = indexOfParent(i);
			if(!isOrderRight(parent, i)){
				int minChild = Math.min((int)heap[indexOfLeftChild(parent)], (int)heap[indexOfRightChild(parent)]);
				swap(parent, minChild);
				i = parent;
			}else{
				break;
			}
		}
	}
	public boolean isOrderRight(int parent, int i){
		if((int)heap[parent] > (int)heap[i]){
			return false;
		}
		return true;
	}
	public void swap(int left, int right){
		Object temp = heap[left];
		heap[left] = heap[right];
		heap[right] = temp;
	}
	public Object poll(){
		validateIndex(index-1);
		Object giveIt = heap[0];
		heap[0] = heap[--index];
		heapifyTop();
		return giveIt;
	}
	public void heapifyTop(){
		for(int i=0; i<heap.length;){
			int parent = i;
			int minChild = Math.min((int)heap[indexOfLeftChild(parent)], (int)heap[indexOfRightChild(parent)]);
			if(!isOrderRight(parent, minChild)){
				swap(parent, minChild);
				i = minChild;
			}else{
				break;
			}
		}
	}
}
