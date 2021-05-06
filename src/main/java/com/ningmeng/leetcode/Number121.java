package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-05 22:21:50
 * @Version 1.0
 */
public class Number121 {

	public static void main(String[] args) {
		int[] arr = {7,6,4,3,1};
		System.out.println(maxProfit(arr));
	}

	public static int maxProfit(int[] prices) {

		int res = 0;
		int[] dp = new int[prices.length];

		dp[0] = 0;
		int min = prices[0];

		for(int i = 1; i < prices.length; i++) {
			dp[i] = Math.max(dp[i - 1], prices[i] - min);
			min = Math.min(prices[i], min);
		}

		return dp[prices.length - 1];

	}
}
