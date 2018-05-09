package challenges.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
* @date	Apr 25, 2018 12:43:29 PM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class WordsSearch {
	public static void fill(char[][] board, TrieNode head){
		for(int i=0; i<board.length; i++){
			for(int j=0; j<board[0].length; j++){
				if(head.children_array[board[i][j]-'a']==null){
					head.insert(""+board[i][j]);
				}
			}
		}
	}
	public static List<String> findWords(char[][] board, String[] words){
		List<String> list = new ArrayList<String>();
		TrieNode head = new TrieNode();
		fill(board, head);
		for(String s: words){
			TrieNode root = head;
			if(check(root, s, board)){
				list.add(s);
			}
		}
		return list;
	}
	public static boolean check(TrieNode root, String s, char[][] board){
		
		for(char c: s.toCharArray()){
			if(root.children_array[c-'a'] == null){
				return false;
			}
			root = root.children_array[c-'a'];
			insertNext(root, board);
		}
		return true;
	}
	public static void insertNext(TrieNode root, char[][] board){
		
	}
	public static void main(String[] args) {
		char[][] brd = new char[4][];
		
	}
}
