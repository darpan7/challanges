package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import common.IO;

/**
* @author {
* 	Name: Darpan Shah
* 	Date: Mar 30, 2018 11:06:28 AM
* }
*/
/*
Problem:
=======
Alphabet Cake
https://code.google.com/codejam/contest/5304486/dashboard#s=p0
Code Jam Round 1A 2017
*/

public class AlphabetCake {

	public static void main(String[] args) throws IOException {
		BufferedReader br = IO.getReader("in/B-large-practice.in");
		String TC = br.readLine();
		int tc = Integer.parseInt(TC);
		while (tc-- > 0) {
			String size = br.readLine();
			int row = Integer.parseInt(size.split(" ")[0]);
			int col = Integer.parseInt(size.split(" ")[1]);
			char[][] matrix = loadMatrix(br, row, col);
			Set<String> saveOrgLetters = saveLetters(matrix);
			Map<String, Set<Rectangle>> map = new HashMap<String, Set<Rectangle>>();
			for(int i=0; i<matrix.length; i++){
				for(int j=0; j<matrix[0].length; j++){
					if(matrix[i][j]!='?' && saveOrgLetters.contains(i+""+j)){
						placeRectangleFor(matrix, i, j, map, saveOrgLetters);
					}
				}
			}
		}
		br.close();
	}
	@SuppressWarnings("unused")
	public static void placeRectangleFor(char[][] matrix, int i, int j, Map<String, Set<Rectangle>> map, Set<String> saveOrgLetters){
		int r = matrix.length;
		int c = matrix[0].length;
		int w = 1;
		int l = 1;
		// top,bottom
		int top = i;
		while(top>=0 && (top==i || matrix[top][j]=='?' || !saveOrgLetters.contains(matrix[top][j]))){
			matrix[top][j] = matrix[i][j];
			--top;
		}
		w = Math.abs(i - top);
		int rollback = top;
		boolean isRollback = true;
		// left
		int left_i = top;
		int left_j = j;
		while(left_j>=0 && (left_j==j || matrix[left_i][left_j]=='?' || !saveOrgLetters.contains(matrix[left_i][left_j]))){
			matrix[left_i][left_j] = matrix[i][j];
			--left_j;
		}
		l = Math.abs(j - left_j);
		
		// bottom
		int bot_i = left_i;
		int bot_j = left_j;
		while(bot_i<r || bot_i==left_i ){
			if(matrix[bot_i][bot_j]=='?' || !saveOrgLetters.contains(matrix[bot_i][bot_j])){
				matrix[bot_i][bot_j] = matrix[i][j];
				++bot_i;
			}
		}
		
		// left,right
	}
	public static char[][] loadMatrix(BufferedReader br, int row, int col) throws IOException{
		char[][] matrix = new char[row][col];
		for(int i=0; i<row; i++){
			String line = br.readLine();
			for(int j=0; j<col; j++){
				matrix[i][j] = line.charAt(j);
			}
		}
		return matrix;
	}
	public static Set<String> saveLetters(char[][] matrix){
		Set<String> set = new HashSet<String>();
		for(int i=0; i<matrix.length; i++){
			for(int j=0; j<matrix[0].length; j++){
				if(matrix[i][j]!='?')
					set.add(i+""+j);
			}
		}
		return set;
	}
}
class Rectangle {
	public int a1;
	public int b1;
	public int a2;
	public int b2;
	
	public Rectangle(int a1, int b1, int a2, int b2){
		this.a1 = a1;
		this.b1 = b1;
		this.a2 = a2;
		this.b2 = b2;
	}
}
