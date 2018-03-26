package challenges;

import java.util.Scanner;
import java.util.Stack;

/**
* @date	Mar 26, 2018 2:23:39 PM
* @author Darpan Shah
*/
/*
Problem:
=======
Replace all ‘0’ with ‘5’ in an input Integer
Given a integer as a input and replace all the ‘0’ with ‘5’ in the integer.
Examples: 
    102 - 152
    1020 - 1525 
Use of array to store all digits is not allowed.
 */
public class Challenge15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while(t >0){
        	int n = scanner.nextInt();
        	//1
        	String s = String.valueOf(n);
        	s = s.replaceAll("0", "5");
        	System.out.println("method1:" + Integer.valueOf(s));
        	
        	//2
        	Stack<Integer> number = new Stack<Integer>();
        	int mod = 0;
        	int no = n;
        	while(no>0){
        		mod = no%10;
        		if(mod==0){
        			number.push(5);
        		}else{
        			number.push(mod);
        		}
        		no = no/10;
        	}
        	String stack = "";
        	while(!number.isEmpty()){
        		stack += number.pop();
        	}
        	System.out.println("method2:" +Integer.valueOf(stack));
        	
        	//3
        	int md = 0;
        	int num = n;
        	int output = 0;
        	int times = 0;
        	while(num>0){
        		md = num%10;
        		if(md==0){
        			output += Math.pow(10,times)*5;
        		}else{
        			output += Math.pow(10,times)*md;
        		}
        		++times;
        		num = num/10;
        	}
        	System.out.println("method3:" +output);
        	--t;
        }
        scanner.close();
	}

}
