package challenges.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
* @date	Jul 24, 2018 2:47:38 PM
* @author Darpan Shah
*/

public class SubString {

	public static List<String> listAllSubStrings(String s){
		if(s == null || s.length() < 1 || s.trim().equals("") || s.trim().length() <1)
			return null;
		List<String> substrings = new ArrayList<>();
		for(int i=0; i<s.length(); i++){
			substrings.add(String.valueOf(s.charAt(i)));
			StringBuilder buffer = new StringBuilder(String.valueOf(s.charAt(i)));
			for(int j=i+1; j<s.length(); j++){
				buffer.append(s.charAt(j));
				substrings.add(buffer.toString());
			}
		}
		return substrings;
	}
	
	public static Map<Integer, List<String>> mapOfAllSubStrings(String s){
		if(s == null || s.length() < 1 || s.trim().equals("") || s.trim().length() <1)
			return null;
		Map<Integer, List<String>> map = new HashMap<>();
		for(int i=0; i<s.length(); i++){
			List<String> list = map.getOrDefault(1, new ArrayList<>());
			list.add(String.valueOf(s.charAt(i)));
			map.put(1, list);
			StringBuilder buffer = new StringBuilder(String.valueOf(s.charAt(i)));
			for(int j=i+1; j<s.length(); j++){
				buffer.append(s.charAt(j));
				List<String> lst = map.getOrDefault(buffer.length(), new ArrayList<>());
				lst.add(buffer.toString());
				map.put(buffer.length(), lst);
			}
		}
		map.remove(s.length());
		return map;
	}
	
	public static void main(String[] args) {
		System.out.println(mapOfAllSubStrings("abcd").size() + ", " + mapOfAllSubStrings("abcd"));
		System.out.println(mapOfAllSubStrings("abba").size() + ", " + mapOfAllSubStrings("abba"));
		System.out.println(mapOfAllSubStrings("kkkk").size() + ", " + mapOfAllSubStrings("kkkk"));
		System.out.println(mapOfAllSubStrings("ifailuhkqq").size() + ", " + mapOfAllSubStrings("ifailuhkqq"));
	}

}
