package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-20 21:23:29
 * @Version 1.0
 */
public class Number122 {



	public int maxProfit(int[] prices) {
		int[] dp = new int[prices.length];
		dp[0] = 0;
		// f(n) = max(price[i] - price[i - 1], 0) + f(n - 1)
		for(int i = 1; i < prices.length; i++) {
			dp[i] = Math.max(prices[i] - prices[i - 1], 0) + dp[i - 1];
		}

		return dp[prices.length - 1];

	}
}
