package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 22:20:17
 * @Version 1.0
 */
public class Number977 {

	// 双指针从两侧向中间靠拢
	// 每次移动绝对值最大的那个指针

	public int[] sortedSquares(int[] nums) {
		int l = 0;
		int r = nums.length - 1;
		int[] res = new int[nums.length];
		int index = res.length - 1;
		while(l <= r) {
			if (Math.abs(nums[l]) > Math.abs(nums[r])) {
				res[index--] = nums[l] * nums[l];
				l++;
			} else {
				res[index--] = nums[r] * nums[r];
				r--;
			}
		}

		return res;

	}
}
