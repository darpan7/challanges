package amazon;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import common.Trie;
import common.TrieNode;

/**
* @date	Apr 4, 2018 8:59:03 AM
* @author Darpan Shah
*/
/*
Problem:
=======
Find the k most frequent words from a file
Given a non-empty list of words, return the k most frequent elements.
Your answer should be sorted by frequency from highest to lowest. 
If two words have the same frequency, then the word with the lower alphabetical order comes first.
Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.

Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
Note:
    You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
    Input words contain only lowercase letters.
Follow up:
    Try to solve it in O(n log k) time and O(n) extra space.
    
Input:
2
6 2
i love leetcode i love coding
10 4
the day is sunny the the the sunny is is
Output:
i love
the is sunny day
*/
public class KMostFreqWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int k = scanner.nextInt();
			List<String> list = loadWords(scanner, n);
			List<String> output = findKMostFreqWords(list, k);
			System.out.println(output);
			--T;
		}
		scanner.close();
	}
	public static List<String> loadWords(Scanner scanner, int n){
		List<String> list = new ArrayList<String>();
		for(int i=0; i<n; i++){
			list.add(scanner.next());
		}
		scanner.nextLine();
		return list;
	}
	public static List<String> findKMostFreqWords(List<String> list, int k){
		Trie root = new Trie(list.size());
		PriorityQueue<TrieNode> heap = createHeap(k);
		for(String word: list){
			TrieNode node = root.get(word);
			if(node == null){
				node = root.add(word);
			}else{
				node.freq++;
			}
			heap.offer(node);			
		}
		return takeFirstKWordsFrom(heap, k);
	}
	public static List<String> takeFirstKWordsFrom(PriorityQueue<TrieNode> ks, int k){
		List<String> output = new ArrayList<String>(k);
		int i=0;
		String last = null;
		while(!ks.isEmpty() && i<k){
			String d = ks.poll().data;
			if(last==null){
				last = d;
				output.add(d);
				i++;
			}else{
				if(!last.equals(d)){
					last = d;
					output.add(d);
					i++;
				}
			}
		}
		return output;
	}
	public static PriorityQueue<TrieNode> createHeap(int k){
		PriorityQueue<TrieNode> ks = new PriorityQueue<TrieNode>(k, (o1, o2) -> {
			if(o1.freq != o2.freq){
				return o2.freq - o1.freq;
			}
			return o1.data.compareTo(o1.data);
		});
		return ks;
	}
}