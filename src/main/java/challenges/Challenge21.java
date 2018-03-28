package challenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* @date	Mar 28, 2018 11:27:08 AM
* @author Darpan Shah
*/
/*
Problem:
=======
In given range, print all numbers having unique digits. e.g. In range 1 to 20 should print all numbers except 11.
*/
public class Challenge21 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int from = scanner.nextInt();
			int to = scanner.nextInt();
			//method 1 O((to-from)*length(to))
			StringBuilder s = new StringBuilder();
			int counter = 0;
			for(int i=from; i<=to; i++){
				String n = String.valueOf(i);
				List<Character> digits = new ArrayList<Character>(10);
				StringBuilder sb = new StringBuilder();
				for(char ch: n.toCharArray()){
					if(!digits.contains(ch)){
						digits.add(ch);
						sb.append(ch+"");
					}else{
						sb.delete(0, sb.length());
						break;
					}
				}
				if(sb.length()>0){
					++counter;
					s.append(sb.toString());s.append(" ");
				}
			}
			System.out.println(s.toString().trim());
			System.out.println(counter);
			
			--T;
		}
		scanner.close();
	}
}
// Not working class.
class UniqueDigits
{
    public static int CountNumbersHavingUniqueDigits(int min, int max) {
        int minCount = CountNumbersHavingUniqueDigitsFromZero(min-1);
        int maxCount = CountNumbersHavingUniqueDigitsFromZero(max);

        return maxCount-minCount;
    }
   
    public static int CountNumbersHavingUniqueDigitsFromZero(int number) {
        int finalCount = 0;

        // (1) Count all combinations that have digits less than this number.
        finalCount += CountUniqueDigitsWithLessDigits(number);

        // (2) Count all combinations with the first digit ranges.
        finalCount += CountUniqueDigitsWithFirstDigitRange(number);

        // (3) Count all combinations for all other digit ranges.
        finalCount += CountUniqueDigitsWithDigitRanges(number);

        return finalCount;
    }

    public static int CountUniqueDigitsWithLessDigits(int number) {
        String strNumber = Integer.toString(number);
        int digits = strNumber.length();
        int lessDigits = digits - 1;
        int initialDigitPossibilities = 9;
        if (digits == 1) {
            return initialDigitPossibilities;
        }

        int combinationCount = 0;
        for (int i = 1; i <= lessDigits; i++) {
            int curDigitCount = initialDigitPossibilities;
            for (int j = 2; j <= i; j++) {
                curDigitCount *= (11 - j);
            }
         
            combinationCount += curDigitCount;
        }  

        return combinationCount;
    }

    public static int CountUniqueDigitsWithFirstDigitRange(int number) {
        String strNumber = Integer.toString(number);
        int digits = strNumber.length();
        int firstDigit = Character.getNumericValue(strNumber.charAt(0));
        
        int combinationCount = firstDigit;
        for (int i = 2; i <= digits; i++) {
            combinationCount *= (11 - i);
        }

        return combinationCount;
    }

    public static int CountUniqueDigitsWithDigitRanges(int number) {
        String strNumber = Integer.toString(number);
        int digits = strNumber.length();

        int combinationCount = 0;
        int minDigit = 0;
        for (int i = 1; i <= digits; i++) {
            int curDigit = Character.getNumericValue(strNumber.charAt(i-1));
            int curDigitCount = curDigit;
            if (i == digits) {
                combinationCount += curDigitCount;
                continue;
            }

            int nextDigit = Character.getNumericValue(strNumber.charAt(i));
            int collisionsWithPrevious = 0;
            for (int j = 1; j <= i; j++) {
                int digit = Character.getNumericValue(strNumber.charAt(i));
                if (digit <= nextDigit) {
                    collisionsWithPrevious++;
                }
            }
            
            int nextDigitPossibilities = nextDigit - collisionsWithPrevious;
            curDigitCount *= nextDigitPossibilities;
            
            for (int j = i+1; j <= digits; j++) {
                curDigitCount *= (10 - j);
            }

            combinationCount += curDigitCount;
        }
         
        return combinationCount;
    }
}
