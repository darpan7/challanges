package challenges.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
* @date	Apr 24, 2018 3:28:32 PM
* @author Darpan Shah
*/
/*
===================================
TrieNode with array/map representation!
*/
public class TrieNode {
	public static final int N = 26;
	public boolean isword = false;
	public TrieNode[] children_array = new TrieNode[N];
	public Map<Character, TrieNode> children_map = new HashMap<>(); 
	
	public TrieNode(){
		
	}
	public void insert(String s){
		TrieNode curr = this;
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
				curr.children_array[ch-'a'] = new TrieNode(); 
			}
			curr = curr.children_array[ch-'a'];
		}
		curr.isword = true;
	}
	private void fill(Queue<TrieNode> q, TrieNode cur, char ch){
		if(ch == '.'){
			for(TrieNode tn: cur.children_array){
				if(tn!=null)
					q.offer(tn);
			}
		}else if(cur.children_array[ch-'a']!=null){
			q.offer(cur.children_array[ch-'a']);
		}
		
	}
	public boolean searchWithRegex(String s){
		if(s == null || s.length() <1 || s.equals(""))
			return false;
		char fst = s.charAt(0);
		TrieNode curr = this;
		Queue<TrieNode> queue = new LinkedList<>();
		fill(queue, curr, fst);
		int len = queue.size();
		s = s.substring(1);
		for(char ch: s.toCharArray()){
			while(len>0 && !queue.isEmpty()){
				TrieNode temp = queue.poll();
				fill(queue, temp, ch);
				--len;
			}
			len = queue.size();
		}
		if(queue.isEmpty())
			return false;
		while(!queue.isEmpty()){
			if(queue.poll().isword)
				return true;
		}
		return false;
	}
	
	public boolean contains(String s){
		TrieNode curr = this;
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
				return false; 
			}
			curr = curr.children_array[ch-'a'];
		}
		return true;
	}
	public boolean search(String s) {
		TrieNode curr = this;
		for(char ch: s.toCharArray()){
			if(curr.children_array[ch - 'a'] == null){
				return false; 
			}
			curr = curr.children_array[ch-'a'];
		}
		return curr.isword;
    }
	
	public static void main(String[] args) {
		TrieNode root = new TrieNode();
		root.insert("bed");
		root.insert("bad");
		root.insert("beer");
		root.insert("bedroom");
		System.out.println("bed is cotained? " + root.contains("bed"));
		System.out.println("beer is cotained? " + root.contains("beer"));
		System.out.println("bad is cotained? " + root.contains("bad"));
		System.out.println("bedroom is cotained? " + root.contains("bedroom"));
		System.out.println("bed is word? " + root.search("bed"));
		System.out.println("bedroom is word? " + root.search("bedroom"));
		System.out.println("bedroo is word? " + root.search("bedroo"));
		System.out.println("bald is cotained? " + root.contains("bald"));
		
	}
	
}
