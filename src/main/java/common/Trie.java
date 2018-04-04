package common;

import java.util.HashMap;
import java.util.Map;

/**
* @date	Apr 4, 2018 11:21:49 AM
* @author Darpan Shah
*/

public class Trie {
	public TrieNode root;
	public Map<String, TrieNode> map;
	
	public Trie(int n){
		this.map = new HashMap<String, TrieNode>(n);
	}
	public Trie(){
		this(16);
	}
	
	public TrieNode get(String word){
		return map.get(word);
	}
	
	public TrieNode add(String word){
		TrieNode node = new TrieNode(word, 1);
		map.put(word, node);
		return node;
	}
}
