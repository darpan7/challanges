package challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
* @date	Apr 17, 2018 4:07:18 PM
* @author Darpan Shah
*/
/*
Problem:
=======
3 Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
[-1 -1 -1 0 1 2 -2]
[
  [-2,0,2],
  [-1,-1,2],
  [-1,0,1]
]
2
6
-1 0 1 2 -1 -4
7
-1 -1 -1 0 1 2 -2
4
1 2 -2 -1
*/
public class Challenge26 {
	public static void getValues(Scanner scanner, int[] d){
		for(int i=0; i<d.length; i++){
			int data = scanner.nextInt();
			d[i] = data;
		}
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		while (T > 0) {
			int n = scanner.nextInt();
			int[] nums = new int[n];
			getValues(scanner, nums);
			//System.out.println(threeSum(nums)); // Not Optimized
			System.out.println(threeSum1(nums)); // Improved!
			--T;
		}
		scanner.close();
	}
	
	public static List<List<Integer>> threeSum1(int[] nums) {
		Arrays.sort(nums);
		Set<List<Integer>> set = new HashSet<List<Integer>>();
        for(int i=0; i<nums.length; i++){
        	int low = i+1;
        	int high = nums.length-1;
        	int need = 0 - nums[i] ;
        	while(low < high) {
        		int sum = nums[low] + nums[high];
        		if(sum == need){
        			set.add(Arrays.asList(nums[i], nums[low], nums[high]));
        			low++;
        			high--;
        		}
        		if(sum < need){
        			low++;
        		}else{
        			high--;
        		}
        	}
        }
        return new ArrayList<List<Integer>>(set);
    }
	public static List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Map<Integer, Set<Integer>> map = new HashMap<Integer, Set<Integer>>();
        for(int i=0; i<nums.length; i++){
        	Set<Integer> list = map.get(nums[i]);
        	if(list==null)
        		list = new HashSet<Integer>();
        	list.add(i);
        	map.put(nums[i], list);
        }
        System.out.println(map);
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                int sub = nums[i] + nums[j];
                int need = sub*-1;
                if(map.get(need)!=null){
                	Set<Integer> lst = map.get(need);
                	boolean found = false;
                	if(lst.size() == 1 && (lst.contains(i) || lst.contains(j)))
                		found = true;
//                	for(int id: lst){
//                		if(id != i && id != j){
//                			found = true;
//                		}
//                	}
                	if(found){
                		List<Integer> list = new ArrayList<Integer>();
                        list.add(nums[i]); list.add(nums[j]); list.add(need);
                        Collections.sort(list);
                        set.add(list);
                	}
                }
            }
        }
        return new ArrayList<List<Integer>>(set);
    }
}
