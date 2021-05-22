package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-22 19:41:38
 * @Version 1.0
 */
public class Number674 {

	// 不是动态规划
	public int findLengthOfLCIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int res = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				dp[i] = dp[i - 1] + 1;
				res = Math.max(dp[i], res);
			} else {
				dp[i] = 1;
			}
		}
		return res;
	}
}
