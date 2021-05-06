package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 09:02:05
 * @Version 1.0
 */
public class JZ42 {

	public static void main(String[] args) {
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArray(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		int max = dp[0];
		for (int i = 1; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
			max = Math.max(dp[i], max);
		}

		return max;


	}
}
