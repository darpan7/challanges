package common;

import java.util.Stack;

/**
* @date	Mar 27, 2018 9:48:55 AM
* @author Darpan Shah
*/
public class Binary {
	public static String intToBinary(int n){
		Stack<Integer> stack = new Stack<Integer>();
		while(n>0){
			stack.push((n%2));
			n /=2;
		}
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()){
			sb.append(stack.pop());
		}
		return sb.toString();
	}
	
	public static int positionOfBit(int n, int lookingFor, int direction){
		Stack<Integer> stack = new Stack<Integer>();
		int index = 1;
		while(n>0){
			int mod = (n%2);
			if(direction == -1 && mod == lookingFor){
				return index; 
			}
			stack.push(mod);
			n /=2;
			++index;
		}
		StringBuilder sb = new StringBuilder();
		index = 1;
		while(!stack.isEmpty()){
			int digit = stack.pop();
			if(direction != -1 && digit == lookingFor){
				return index;
			}
			sb.append(digit);
			++index;
		}
		return 0;
	}
}
