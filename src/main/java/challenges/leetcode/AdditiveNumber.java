package challenges.leetcode;

/**
* @date	Aug 17, 2018 11:18:29 AM
* @author Darpan Shah
*/

public class AdditiveNumber {
	public static boolean isAdditiveNumber(String num) {
        if(num == null || num.length() < 3)
            return false;
        long fst = 0;
        for(int i=1; i<num.length()-1; i++){
            fst = Long.parseLong(num.substring(0, i));
            System.out.println(fst + ": " + num.substring(i));
            if(canpass(num.substring(i), i, fst))
                return true;
            if(fst == 0)
            	break;
        }
        return false;
    }
    public static boolean canpass(String num, int id, long fst){
        //System.out.println("1st mthd: " + num);
        for(int i=1; i<num.length(); i++){
            long scd = Long.parseLong(num.substring(0, i));
            System.out.println(fst + " + " + scd + ": " + num.substring(i));
            if(canpass(num.substring(i), i, fst, scd))
                return true;
            if(scd == 0)
            	break;
        }
        return false;
    }
    
    public static boolean canpass(String num, int id, long fst, long scd){
        long a = fst;
        long b = scd;
        if(num == null || num.length() < 1)
        	return false;
        if(num.length() == 1){
        	long c = Long.parseLong(num);
        	System.out.println(fst + " + " + scd + " ?= " + c + ": " );
        	if(c >= a && c >= b && (c - b) == a){
        		System.out.println(fst + " + " + scd + " = " + c + ": " );
            	return true;
            }
        	return false;
        }
        //System.out.println("2nd mthd: " + num);
        for(int i=1; i<=num.length(); i++){
            long c = Long.parseLong(num.substring(0, i));
            System.out.println(fst + " + " + scd + " ?= " + c + ": " + num.substring(i));
           
            if(c >= a && c >= b && (c - b) == a){
            	System.out.println(fst + " + " + scd + " = " + c + ": " + num.substring(i));
            	 if(i != num.length()){
                 	if(canpass(num.substring(i), i, scd, c))
                 		return true;
                 }else{
                	 return true;
                 }
            }else if((a + b) < c){
            	break;
            }
            if(c == 0)
            	break;
        }
        return false;
    }
	public static void main(String[] args) {
		boolean ans = isAdditiveNumber("1023"); // 
		System.out.println(ans);
	}

}
