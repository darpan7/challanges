package common;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
* @date	Mar 27, 2018 2:07:35 PM
* @author Darpan Shah
*/

public class StringOperator {
	public static Set<String> permutaionOf(String s, String delim){
		Set<String> strings = new TreeSet<String>();
		strings.add(s);
		if(s.length()==1){
			return strings;
		}
		for(int i=1; i<s.length(); i++){
			String s1 = s.substring(0, i);
			String s2 = s.substring(i);
			Set<String> set1 = permutaionOf(s1, delim);
			Set<String> set2 = permutaionOf(s2, delim);
			set1.stream().forEach(ss1 -> set2.stream().forEach(ss2 -> strings.add(ss1+delim+ss2)));
		}
		return strings;
	}
	
	public static Set<String> permutationUsingNode(String s, char delim){
		Set<String> set = new TreeSet<String>();
		StringNode root = new StringNode(s.charAt(0));
		StringNode node = root;
		
		if(s.length()>1){
		    permutationUsingNode(s.substring(1), delim, node);
		    StringNode.loadSet(root, "", set);
		}
		else
		    set.add(s);
		return set;
	}

	public static void permutationUsingNode(String s, char delim, StringNode root) {
		StringNode node = root;
		int i = 0;
		char ch = s.charAt(i);
		StringNode left = new StringNode(ch);
		node.left = left;
		if (node.name != delim) {
			StringNode right = new StringNode(delim);
			node.right = right;
			if (s.length() > 1) {
				permutationUsingNode(s.substring(i + 1), delim, node.left);
			}
			permutationUsingNode(s, delim, node.right);
		} else if (s.length() > 1) {
			permutationUsingNode(s.substring(i + 1), delim, node.left);
		}
	}
	public static class StringNode{
		public char name;
		public StringNode left;
		public StringNode right;
		
		public StringNode(char name){
			this.name = name;
		}
		public static void loadSet(StringNode root, String sb, Set<String> set){
			if(root == null){
				set.add(sb.toString());
				
			}else{
				sb += root.name;
				loadSet(root.left, sb, set);
				if(root.right!=null)
					loadSet(root.right, sb, set);
			}
		}
	}
	
	public static Set<String> allPermutations(String s){
		Set<String> set = new HashSet<String>();
		startPermutation(set, "", s);
		return set;
	}
	
	public static void startPermutation(Set<String> set, String prefix, String s){
		if(s.length()==0){
			set.add(prefix);
			return;
		}
		for(int i=0; i<s.length(); i++){
			startPermutation(set, prefix+s.charAt(i), s.substring(0, i) + s.substring(i+1));
		}
	}
//	public static void main(String[] args) {
//		Set set = allPermutations("abcd"); 
//		System.out.println(set.size() + " " + set);
//		set = allPermutations("abcde"); 
//		System.out.println(set.size() + " " + set);
//		set = allPermutations("abcdef"); 
//		System.out.println(set.size() + " " + set);
//	}
}

