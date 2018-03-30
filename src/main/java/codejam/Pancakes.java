package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import common.IO;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 29, 2018 5:04:00 PM
* }
*/
/*
Problem:
=======
Revenge of the Pancakes
https://code.google.com/codejam/contest/6254486/dashboard#s=p1
Code Jam Qualification Round 2016
*/
public class Pancakes {
	public static void main(String[] args) throws IOException {
//		BufferedReader br = IO.getReader("in/B-small-practice.in");
		BufferedReader br = IO.getReader("in/B-large-practice.in");
		String stack = br.readLine();
		StringBuilder sb = new StringBuilder();
		int solution = 1;
		while ((stack=br.readLine())!=null) {
			int flips = 0;
			char now = 0;
			for(int i=0; i<stack.length(); i++){
				char current = stack.charAt(i);
				if(i==0){
					now = current;
				}
				switch(current){
					case '-':
						i = groupSameFaces(current, i, stack);
						switch(now){
							case '+':
								flips += 2;
								break;
							case '-':
								flips += 1;
								now = '+';
								break;
						}
						break;
				}
			}
			sb.append("Case #" + (solution++) + ": " + flips); sb.append("\n");
		}
		br.close();
//		IO.writeToFile(sb.toString().trim(), "src/main/resources/out/B-small-practice.out");
//		System.out.println("Output stored to src/main/resources/out/B-small-practice.out!");
		IO.writeToFile(sb.toString().trim(), "src/main/resources/out/B-large-practice.out");
		System.out.println("Output stored to src/main/resources/out/B-large-practice.out!");
	}
	public static int groupSameFaces(char current, int i, String stack){
		int next = i;
		for(int j=i+1; j<stack.length(); j++){
			char fwd = stack.charAt(j);
			if(fwd == current){
				++next;
			}else{
				break;
			}
		}
		return next;
	}

}
