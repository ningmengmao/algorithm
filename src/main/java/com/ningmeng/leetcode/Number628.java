package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-22 20:02:56
 * @Version 1.0
 */
public class Number628 {
	public int maximumProduct(int[] nums) {
		if (nums.length == 3) {
			return nums[0] * nums[1] * nums[2];
		}

		Arrays.sort(nums);

		int res = 0;

		int length = nums.length;


		int a = nums[0] * nums[1] * nums[nums.length - 1];
		int b = nums[length - 1] * nums[length - 2] * nums[length - 3];
		return Math.max(a, b);



	}
}
