package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-06-05 10:15:33
 * @Version 1.0
 */
public class Number217 {
	public boolean containsDuplicate(int[] nums) {
		Arrays.sort(nums);

		for(int i = 1; i < nums.length; i++) {
			if (nums[i - 1] == nums[i]) {
				return true;
			}
		}
		return false;

	}
}
