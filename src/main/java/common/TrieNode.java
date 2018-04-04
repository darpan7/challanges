package common;
/**
* @date	Apr 4, 2018 11:42:49 AM
* @author Darpan Shah
*/

public class TrieNode {
	public int freq;
	public String data;
	
	public TrieNode(String data, int n){
		this.data = data;
		this.freq = n;
	}
	public TrieNode(int n){
		this(null, n);
	}
}
