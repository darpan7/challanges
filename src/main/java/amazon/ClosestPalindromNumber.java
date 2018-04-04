package amazon;

import java.util.Scanner;

/**
* @date	Apr 3, 2018 2:41:54 PM
* @author Darpan Shah
*/
/*
Problem 1:
=======
Closest Palindrome Number (absolute difference Is min)
Given a number N. how can you find the closest Palindrome number whose absolute difference with given number is minimum?
Given a number N. our task is to find the closest Palindrome number whose absolute difference with given number is minimum and absolute difference must be greater than 0.
Examples:
Input :  N = 121 
Output : 131 or 111   
Both having equal absolute difference
with the given number.

Input : N = 1234
Output : 1221
*/
public class ClosestPalindromNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			String text = scanner.next();
			int length = text.length();
			int n = Integer.parseInt(text);
			Integer middle = findMiddle(text, length);
			System.out.println("middle="+middle + ", len="+length);
			int left = leftSide(n, length);
			int right = rightSide(n, length);
			System.out.println("left="+left + ", right="+right);
			if(isPalindrom(left, right)){
				if(middle!=null){
					String s = String.valueOf(left) + (++middle) + String.valueOf(right);
					int value = Integer.parseInt(s);
					System.out.println(value);
				}else{
					left++;
					int rt = right;
					int tens = 0;
					while((rt/10)!=0){
						rt = rt/10;
						++tens;
					}
					right = right + (10*tens);
					String s = String.valueOf(left) + String.valueOf(right);
					int value = Integer.parseInt(s);
					System.out.println(value);
				}
			}else{
				String rt = reverseNumber(left);
				String s = String.valueOf(left);
				if(middle!=null)
					s += middle;
				s += rt;
				int value = Integer.parseInt(s);
				System.out.println(value);
			}
			
			--T;
		}
		scanner.close();
	}
	public static String reverseNumber(int left){
		StringBuilder sb = new StringBuilder(String.valueOf(left));
		return sb.reverse().toString();
		// 0 is missed. i.e. 10 returns 1 instead 01
//		String r = "";
//		while(left>0){
//			int mo = left%10;
//			r += mo;
//			left = left/10;
//		}
//		return r;
	}
	public static boolean isPalindrom(int left, int right){
		while(left>0 && right>0){
			int l = left%10;
			int r = right%10;
			if(l!=r)
				return false;
			left = left/10;
			right = right/10;
		}
		if(left>0 ^ right>0){
			return false;
		}
		return true;
	}
	public static int leftSide(int n, int len){
		int times = findIndex(len);
		return (int) (n/(Math.pow(10, times)));
	}
	public static int findIndex(int len){
		int times = (len%2==0)?(len/2):((len/2) + 1);
		return times;
	}
	public static int rightSide(int n, int len){
		int times = findIndex(len);
		if(len%2!=0)
			times--;
		return (int) (n%(Math.pow(10, times)));
	}
	public static Integer findMiddle(String n, int len){
		if(len%2!=0){
			int index = len/2;
			return new Integer(n.charAt(index)+"");
		}
		return null;
	}

}
