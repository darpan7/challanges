package challenges.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @date Apr 23, 2018 3:07:31 PM
 * @author Darpan Shah
 */
/*
 * Problem: =======
 */
public class Permutation {
	List<List<Integer>> list = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {
		// rec(nums, new int[nums.length], 0);
		rec(nums, new ArrayList<Integer>(), 0);
		return list;
	}

	public void rec(int[] nums, List<Integer> temp, int tempid) {
		if (nums == null) {
			list.add(temp);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (temp.size() > tempid)
				temp.set(tempid, nums[i]);
			else
				temp.add(nums[i]);
			if (nums.length > 1) {
				int[] upd = new int[nums.length - 1];
				int j = 0;
				for (j = 0; j < i; j++) {
					upd[j] = nums[j];
				}
				for (int k = i + 1; k < nums.length; k++) {
					upd[j++] = nums[k];
				}
				rec(upd, temp, tempid + 1);
			} else {
				rec(null, temp, tempid + 1);
			}
		}
	}

	public void rec(int[] nums, int[] temp, int tempid) {
		if (nums == null) {
			list.add(Arrays.stream(temp).boxed().collect(Collectors.toList()));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			temp[tempid] = nums[i];
			if (nums.length > 1) {
				int[] upd = new int[nums.length - 1];
				int j = 0;
				for (j = 0; j < i; j++) {
					upd[j] = nums[j];
				}
				for (int k = i + 1; k < nums.length; k++) {
					upd[j++] = nums[k];
				}
				rec(upd, temp, tempid + 1);
			} else {
				rec(null, temp, tempid + 1);
			}
		}
	}

	public static void main(String[] args) {
		int[] num = new int[] { 1, 2, 3 };
		Permutation p = new Permutation();
		//System.out.println(p.permute(num));
		System.out.println(p.subsets(num));
	}

	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> ret = new ArrayList<List<Integer>>();
		permute(nums, ret, 0, new ArrayList<Integer>());
		return ret;
	}

	private void permute(int[] nums, List<List<Integer>> ret, int index, List<Integer> cur) {
		if (index == nums.length) {
			ret.add(new ArrayList<Integer>(cur));
			return;
		}
		permute(nums, ret, index + 1, cur);
		cur.add(nums[index]);
		permute(nums, ret, index + 1, cur);
		cur.remove(cur.indexOf(nums[index]));
	}

}
