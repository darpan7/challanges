package challenges.leetcode;
/**
* @date	Apr 25, 2018 9:37:08 AM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class WordDictionary {
	static TrieNode root = new TrieNode();
	
	public static void addWord(String word){
		root.insert(word);
	}
	
	public static boolean search(String word){
		return root.searchWithRegex(word);
	}
	
	public static void main(String[] args) {
		addWord("at"); addWord("and");addWord("add");addWord("an");
		System.out.println(search("a"));
		System.out.println(search(".at"));
		addWord("bat");
		System.out.println(search(".at"));
		System.out.println(search("an."));
		System.out.println(search("a.d."));
		System.out.println(search("b."));
		System.out.println(search("a.d"));
		System.out.println(search("."));
	}
}
