package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 09:13:17
 * @Version 1.0
 */
public class Number746 {

	public int minCostClimbingStairs(int[] cost) {
		int[] dp = new int[cost.length];

		dp[0] = 0;
		dp[1] = 0;

		for (int i = 2; i < cost.length; i++) {
			dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
		}

		return Math.min(dp[cost.length - 1] + cost[cost.length - 1], dp[cost.length - 2] + cost[cost.length - 2]);

	}
}
