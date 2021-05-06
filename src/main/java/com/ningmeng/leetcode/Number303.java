package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 20:29:58
 * @Version 1.0
 */
public class Number303 {



	class NumArray {

		int[] dp;

		public NumArray(int[] nums) {
			dp = new int[nums.length];

			dp[0] = nums[0];
			for(int i = 1; i < nums.length; i++) {
				dp[i] = nums[i] + dp[i - 1];
			}
		}

		public int sumRange(int left, int right) {
			if (left == 0) {
				return dp[right];
			}
			return dp[right] - dp[left - 1];

		}
	}
}
