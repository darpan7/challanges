package challenges.leetcode;

import java.util.Scanner;

/**
* @date	Apr 18, 2018 12:40:27 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Longest Palindromic Substring
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

Input:
6
babad
cbbd
aaaa
aaabaa
aabbaba
aaabaaaa
*/
public class Challenge29 {
	static int len = 0;
	static int maxLength = 0;
	static int init = 0;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt(); scanner.nextLine();
		while (T > 0) {
			String n = scanner.nextLine();
			System.out.println(longestPalindrome(n)); // Accepted
			System.out.println(longestPalindrome1(n)); // Optimized O(n) [Leetcode]
			--T;
		}
		scanner.close();
	}
	public static String longestPalindrome1(String s) {
        char[] chars = s.toCharArray();
        len = s.length();
        if (len <= 1) return s;
        for (int i = 0; i < len; i++) {
            i = manacher(chars, i);
        }
        return s.substring(init, init + maxLength);
    }
    public static int manacher(char[] chars, int k) {
        int i = k - 1, j = k;
        while (j < len - 1 && chars[j] == chars[j + 1]) j++;
        int nextCenter = j++;
        while (i >= 0 && j < len && chars[i] == chars[j]) {
            i--;
            j++;
        }
        if (j - i - 1 > maxLength) {
            maxLength = j - i - 1;
            init = i + 1;
        }
        return nextCenter;
    }
	public static String longestPalindrome(String s){
		if(s!=null && s.length()==1){
			return s;
		}
		int max = 1;
		String st = s.substring(0, 1);
		for(int i=0; i<s.length(); i++){
			int last = s.lastIndexOf(s.charAt(i));
			if( last == i || last == -1){
				
			}else{
				String text = s.substring(i, last+1);
				if(text.length() > max){
					if(isPalindrome(text)){
						max = text.length();
						st = text;
					}else{
						last = s.lastIndexOf(s.charAt(i), last-1);
						while(last > 0 && (last+1)>i){
							text = s.substring(i, last+1);
							if(text.length()>max && isPalindrome(text)){
								max = text.length(); st = text;
							}
							last = s.lastIndexOf(s.charAt(i), last-1);
						}
					}
				}
			}
		}
		return st;
	}
	public static boolean isPalindrome(String text){
		for(int low=0, high=text.length()-1; low<high; low++, high--){
			if(text.charAt(low) != text.charAt(high)){
				return false;
			}
		}
		return true;
	}
}
