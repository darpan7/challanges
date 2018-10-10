package challenges.hackerrank;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
* @date	Aug 30, 2018 11:18:35 PM
* @author Darpan Shah
*/

public class IntegerInWord {
	public static String[] word = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten"};
	public static String[] prfx = new String[]{"", "", "Hundred", "Thousand"};
	public static Map<Integer, String[]> rdx_map = new HashMap<>();
	static {
		rdx_map.put(1, new String[]{"", "-", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninty"});
		rdx_map.put(-1, new String[]{"Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"});
	}
	
	public static String inword(int x){
		if(x == 0)
			return "zero";
		Stack<String> stack = new Stack<>();
		int i = 0;
		if(x < 20){
			if(x < 11)
				return word[x];
			return rdx_map.get(-1)[x%10 -1];
		}else{
			int prev = 0;
			int digit = 0;
			while(x!=0){
				prev = digit;
				digit = x%10;
				if(digit!=0 && rdx_map.get(i) == null){
					stack.push(word[digit]+ " " +prfx[i]);
				}else if(digit!=0){
					if("-".equalsIgnoreCase(rdx_map.get(i)[digit])){
						if(!stack.empty()) stack.pop();
						if(prev > 0)
							stack.push(rdx_map.get(-1)[prev-1]);
						else
							stack.push(word[10]);
					}else{
						stack.push(rdx_map.get(i)[digit]);
					}
				}
				x /= 10;
				++i;
			}
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty())
			sb.append(stack.pop() + " ");
		return sb.toString().trim();
	}
	public static void main(String[] args) {
		System.out.print(inword(23) +", "); System.out.print(inword(145)+", "); System.out.print(inword(115)+", ");
		System.out.print(inword(2)+", ");
		System.out.print(inword(13)+", ");
		System.out.print(inword(63)+", ");
		System.out.print(inword(10)+", ");
		System.out.print(inword(100)+", ");
		System.out.println(inword(666)+", ");System.out.println(inword(110)+", ");System.out.println(inword(996)+", ");
		System.out.println(inword(1000)+", ");
		System.out.println(inword(1010)+", ");
	}
}
