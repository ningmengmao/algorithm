package com.ningmeng.leetcode;

import java.util.*;

/**
 * @Author ningmengmao
 * @Date 2021-05-08 13:01:16
 * @Version 1.0
 */
public class Number15 {

	public static void main(String[] args) {
		var arr = new int[]{0,0,0,0};
		List<List<Integer>> lists = threeSum(arr);
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		int[] temp = nums;

		LinkedList<List<Integer>> res = new LinkedList<>();

		Arrays.sort(temp);

		HashSet<Integer> set = new HashSet<>();

		for (int i = 0; i < temp.length - 2; i++) {

			if (i > 0 &&nums[i] == nums[i - 1]) {
				continue;
			}
			int l = i + 1;
			int r = temp.length - 1;


			int target = -nums[i];
			if (target < 0) {
				break;
			}
			while(l < r) {
				int t = nums[l] + nums[r];
				if (t > target) {
					r--;
				} else if (t == target) {

						List<Integer> list = new ArrayList<>(3);
						list.add(nums[i]);
						list.add(nums[l]);
						list.add(nums[r]);
						res.add(list);
					while (l<r && nums[l] == nums[l+1]) l++; // 去重
					while (l<r && nums[r] == nums[r-1]) r--; // 去重

					l++;
					r--;
				} else {
					l++;
				}
			}
		}

		return res;
	}


}
