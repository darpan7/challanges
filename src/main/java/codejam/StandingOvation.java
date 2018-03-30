package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import common.IO;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 29, 2018 4:37:08 PM
* }
*/
/*
Problem:
=======
Standing Ovation
https://code.google.com/codejam/contest/6224486/dashboard#s=p0
Code Jam Qualification Round 2015
*/
public class StandingOvation {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = IO.getReader("in/A-large-practice.in");
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		int solution = 1;
		while ((s=br.readLine())!=null) {
			String[] input = s.split(" ");
			String people = input[1];
			int counter=0;
			int invite = 0;
			int[] audience = getInt(people);
			for(int i=0; i<audience.length; i++){
				if(i==0){
					counter = audience[i];
				}else if(audience[i] != 0){
					if(i<counter){
						counter += audience[i];
					}else{
						invite += (i-counter);
						counter += (i-counter) + audience[i]; 
					}
				}
				
			}
			sb.append("Case #" + (solution++) + ": " + invite); sb.append("\n");
		}
		IO.writeToFile(sb.toString().trim(), "src/main/resources/out/A-large-practice.out");
		System.out.println("Output stored to src/main/resources/out/A-large-practice.out!");
	}
	public static int[] getInt(String people){
		int n = people.length();
		int[] ar = new int[n];
		int i=0;
		for(char ch: people.toCharArray()){
			ar[i++] = Integer.parseInt(String.valueOf(ch));
		}
		return ar;
	}
}
