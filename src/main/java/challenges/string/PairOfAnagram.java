package challenges.string;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
* @date	Jul 24, 2018 3:03:13 PM
* @author Darpan Shah
*/

public class PairOfAnagram {
	
	public static int totalPairsOfAnagrams(String s){
		List<String> substrings = SubString.listAllSubStrings(s);
		if(substrings == null)
			return 0;
		int count = 0;
		for(int i=0; i<substrings.size()-1; i++){
			String a = substrings.get(i);
			for(int j=i+1; j<substrings.size(); j++){
				String b = substrings.get(j);
				if(isAnagram(a, b)){
					++count;
				}
			}
		}
		return count;
	}
	
	public static int totalPairsOfAnagrams1(String s){
		Map<Integer, List<String>> map = SubString.mapOfAllSubStrings(s);
		if(map == null)
			return 0;
		int count = 0;
		for(Map.Entry<Integer, List<String>> entry: map.entrySet()){
			List<String> substrings = entry.getValue();
			for(int i=0; i<substrings.size()-1; i++){
				String a = substrings.get(i);
				for(int j=i+1; j<substrings.size(); j++){
					String b = substrings.get(j);
					if(isAnagram(a, b)){
						++count;
					}
				}
			}
		}
		return count;
	}
	
	public static boolean isAnagram(String a, String b){
		if(a == null || b == null || (a.length() != b.length()))
			return false;
		if(a.equals(b))
			return true;
		char[] x = a.toCharArray(); Arrays.sort(x);
		char[] y = b.toCharArray(); Arrays.sort(y);
		a = String.valueOf(x);
		b = String.valueOf(y);
		if(a.equals(b))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			System.out.println(totalPairsOfAnagrams1(scanner.next()));
			--T;
		}
		scanner.close();

	}

}
