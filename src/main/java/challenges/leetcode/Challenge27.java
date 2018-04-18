package challenges.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
* @date	Apr 18, 2018 8:44:39 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Group Anagrams
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

Note:

    All inputs will be in lowercase.
    The order of your output does not matter.
Input:
1
cab tin pew duh may ill buy bar max doc

*/
public class Challenge27 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); scanner.nextLine();
		while (T > 0) {
			String input = scanner.nextLine();
			String[] strings = input.split(" ");
			System.out.println(groupAnagrams(strings));
			--T;
		}
		scanner.close();
	}
	public static List<List<String>> groupAnagrams(String[] strings){
		List<List<String>> anagrams = new ArrayList<List<String>>();
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
		for(String string: strings){
			int hashcode = getHashCode(string);
			//System.out.println("string:" + string + ", code:" + hashcode);
			List<String> list = map.get(hashcode);
			if(list==null){
				list = new ArrayList<String>();
			}
			list.add(string);
			map.put(hashcode, list);
		}
		for(int key: map.keySet()){
			anagrams.add(map.get(key));
		}
		return anagrams;
	}
	public static int getHashCode(String string){
		int hash = 0;
		char[] chars = string.toCharArray();
		Arrays.sort(chars);
		for(char ch: chars){
			hash = 31*hash + ch;
		}
		return hash;
	}
}
