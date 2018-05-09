package challenges.leetcode;

import java.util.Arrays;

/**
* @date	Apr 24, 2018 9:50:40 AM
* @author Darpan Shah
*/
/*
Problem:
=======
*/
public class SetColors {
	static int rst = -1; 
	static int ren = -1;
	static int wst = -1; 
	static int wen = -1;
	static int bst = -1; 
	static int ben = -1;
	public static void main(String[] args) {
		int[] ar = new int[]{0,2,1}; //0,2,1 //1,1,2,2,0,2,2,2,1,0,1,1,1,0,1,1,1,1 //2,1,0
		System.out.println(Arrays.toString(ar));
		sortColors(ar);
		System.out.println(Arrays.toString(ar));
	}
	public static void sortColors(int[] nums){
		if(nums == null)
            return;
        for(int i=0; i<nums.length; i++){
            switch(nums[i]){
                case 0:
                    if(rst == -1){
                        rst = i;
                    }
                    ren = i;
                    break;
                case 1:
                    if(wst == -1){
                        wst = i;
                    }
                    wen = i;
                    break;
                case 2:
                    if(bst == -1){
                        bst = i;
                    }
                    ben = i;
                    break;
            }
            balance(nums, i);
        }
    }
    public static void balance(int[] nums, int i){
        if(ren != -1 && ren > wst && wst != -1){
            swap(nums, ren, wst);
            int t = ren;
            ren = wst++;
            wen = t;
            if(rst > ren){
            	rst = ren;
            }
        }
        if(ren != -1 && ren > bst && bst != -1){
            swap(nums, ren, bst);
            int t = ren;
            ren = bst++;
            ben = t;
            if(rst > ren){
            	rst = ren;
            }
        }
        if(wen != -1 && wen > bst && bst != -1){
            swap(nums, wen, bst);
            int t = wen;
            wen = bst++;
            ben = t;
            if(wst > wen){
            	wst = wen;
            }
        }
        
    }
    public static void swap(int[] nums, int x, int y){
    	int t = nums[x];
    	nums[x] = nums[y]; nums[y] = t;
    }

}
