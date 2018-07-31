package challenges.geeksforgeeks;
/**
* @date	Jul 20, 2018 10:02:08 AM
* @author Darpan Shah
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

import common.IO;

public class Challenge26 {
    static long[] a;
    static Map<Range, Operation> storage = new HashMap<>();
    static Long max = 0l;
    // Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {
        a = new long[n+1];
        
        for(int[] q: queries){
            for(int i=q[0]; i<=q[1]; i++){
                a[i] += q[2];
                if(a[i] > max){
                    max = a[i];
                }
            }
        }
        return max;
//        for(int[] q: queries){
//            Operation opr = new Operation(new Range(q[0], q[1]), Long.valueOf(q[2]));
//            if(storage.isEmpty()){
//                storage.put(opr.range, opr);
//                if(max < opr.k)
//                    max = opr.k;
//            }else{
//                Add(opr, storage);
//            }
//        }
//        return max;
    }
    static void Add(Operation opr, Map<Range, Operation> strg){
        Range range = opr.range;
        boolean matched = false;
        Set<Range> set = strg.keySet();
        for(Range r: set){
            if(range.a >= r.a && range.b <= r.b){
            	max = nestedAdd(opr, r, strg, max);
                return; //inside
            }
            if( range.a >= r.a && range.a <= r.b && range.b >= r.b ){
                matched = true;
                //overlapped right side, split it.
                max = nestedAdd(new Operation(new Range(range.a, r.b), opr.k), r, strg, max);
                
                if(r.b != range.b){
                    Operation splitOutside = new Operation(new Range(r.b+1, range.b), opr.k);
                    Add(splitOutside, strg);
                }else{
                    return;
                }
            }
            if( range.a <= r.a && range.b <= r.b && range.b >= r.a ){
                matched = true;
                //overlapped left side, split it.
                max = nestedAdd(new Operation(new Range(r.a, range.b), opr.k), r, strg, max);
                
                if(r.a != range.a){
                    Operation splitOutside = new Operation(new Range(range.a, r.a-1), opr.k);
                    Add(splitOutside, strg);
                }else{
                    return;
                }
            }
            if(range.a < r.a && range.b >= r.b){
                matched = true;
                // Shrink, got father.
                max = nestedAdd(new Operation(new Range(r.a, r.b), opr.k), r, strg, max);
                Operation left = new Operation(new Range(range.a, r.a-1), opr.k);
                Add(left, strg);
                
                Operation right = new Operation(new Range(r.b+1, range.b), opr.k);
                Add(right, strg);
            }
        }
        if(!matched){
            strg.put(opr.range, opr);
            if(max < opr.k)
                max = opr.k;
        }
    }
    static Long nestedAdd(Operation opr, Range r, Map<Range, Operation> strg, Long max){
        Operation old = strg.get(r);
        old.add(opr);
        if(max < old.max)
            max = old.max;
        return max;
    }
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
    	System.out.println("start..");
//        String[] nm = scanner.nextLine().split(" ");

//        int n = Integer.parseInt(nm[0]);

//        int m = Integer.parseInt(nm[1]);

        

        BufferedReader rdr = IO.getReader("src/main/resources/array.txt");
        String line = rdr.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);
        int[][] queries = new int[m+1][3];
        int i=0;
		while ((line = rdr.readLine()) != null) {
			if (line.equals("")) {
				continue;
			}
			String[] qs = line.split(" ");
			queries[i++] = new int[] {Integer.parseInt(qs[0]), Integer.parseInt(qs[1]), Integer.parseInt(qs[2])};
		}
		rdr.close();
        
//        for (int i = 0; i < m; i++) {
//            String[] queriesRowItems = scanner.nextLine().split(" ");
//            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//            for (int j = 0; j < 3; j++) {
//                int queriesItem = Integer.parseInt(queriesRowItems[j]);
//                queries[i][j] = queriesItem;
//            }
//        }
        System.out.println("input scanned!");
        long result = arrayManipulation(n, queries);
        System.out.println(">> " + result);
        //bufferedWriter.write(String.valueOf(result));
        //bufferedWriter.newLine();

        //bufferedWriter.close();

        scanner.close();
    }
}
class Operation {
    public Range range;
    public long k;
    public Map<Range, Operation> map;
    public long max;
    
    public Operation(Range range, long k){
        this.range = range; this.k = k;
        this.map = new HashMap<>();
    }
    
    public void add(Operation opr){
        if(map.isEmpty()){
            opr.k += this.k;
            map.put(opr.range, opr);
            if(max < opr.k){
            	max = opr.k;
            }
        }else{
            Add(opr, map);
        }
        
    }
    
    public void Add(Operation opr, Map<Range, Operation> strg){ // 3-79
        boolean matched = false;
        Range range = opr.range; // 3-79
        Set<Range> set = strg.keySet(); // 2-5
        for(Range r: set){
            if(range.a >= r.a && range.b <= r.b){
            	max = nestedAdd(opr, r, strg);
                return; //inside
            }
            if( range.a >= r.a && range.a <= r.b && range.b >= r.b ){
                matched = true;
                //overlapped right side, split it.
                max = nestedAdd(new Operation(new Range(range.a, r.b), opr.k), r, strg);
                
                if(r.b != range.b){
                    Operation splitOutside = new Operation(new Range(r.b+1, range.b), opr.k);
                    Add(splitOutside, strg);
                }else{
                    return;
                }
            }
            if( range.a <= r.a && range.b <= r.b && range.b >= r.a ){
                matched = true;
                //overlapped left side, split it.
                max = nestedAdd(new Operation(new Range(r.a, range.b), opr.k), r, strg);
                
                if(r.a != range.a){
                    Operation splitOutside = new Operation(new Range(range.a, r.a-1), opr.k);
                    Add(splitOutside, strg);
                }else{
                    return;
                }
            }
            if(range.a <= r.a && range.b >= r.b){
                matched = true;
                // Shrink, got father.
                max = nestedAdd(new Operation(new Range(r.a, r.b), opr.k), r, strg);
                Operation left = new Operation(new Range(range.a, r.a-1), opr.k);
                Add(left, strg);
                
                Operation right = new Operation(new Range(r.b+1, range.b), opr.k);
                Add(right, strg);
            }
        }
        if(!matched){
            opr.k += this.k;
            strg.put(opr.range, opr);
            if(max < opr.k)
                max = opr.k;
        }
    }
    long nestedAdd(Operation opr, Range r, Map<Range, Operation> strg){
        Operation old = strg.get(r);
        old.add(opr);
        if(this.max < old.max)
        	this.max = old.max;
        return this.max;
    }

	@Override
	public String toString() {
		return "Operation [range=" + range + ", k=" + k + ", map=" + map + ", max=" + max + "]";
	}
    
}
class Range {
    public int a;
    public int b;
    
    public Range(int x, int y){
        this.a = x; this.b = y;
    }

	@Override
	public String toString() {
		return "[a=" + a + ", b=" + b + "]";
	}
    
}
