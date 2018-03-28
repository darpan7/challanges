package common;

import java.util.Scanner;

/**
* @date	Mar 19, 2018 1:22:58 PM
* @author Darpan Shah
*/
public class Reader {
	
	public static Scanner getScanner(){
		return new Scanner(System.in);
	}
	
	public static void loadMatrix(Scanner scanner, int[][] matrix, int row, int col){
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
	}

}
