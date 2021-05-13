package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 09:16:27
 * @Version 1.0
 */
public class Number1269 {

	public static void main(String[] args) {
		System.out.println(numWays(500, 10000));
	}


	// 这也配叫hard?!

	public static int numWays(int steps, int arrLen) {
		if (arrLen < 2) {
			return 1;
		}
		int len = Math.min(arrLen, steps / 2 + 1);
		int[][] dp = new int[len][steps];

		// f(n, m) = f(n - 1, m - 1) + f(n + 1, m - 1) + f(n, m - 1)

		dp[0][0] = 1;
		dp[1][0] = 1;
		double v = Math.pow(10, 9) + 7;

		for(int i = 1; i < steps; i++) {

			for(int j = 0; j < len; j++) {
				long sum = 0;
				if(j - 1 > -1) {
					sum += dp[j - 1][i - 1];
				}
				if (j + 1 < len) {
					sum += dp[j + 1][i - 1];
					sum = (long) (sum % v);
				}
				sum += dp[j][i - 1];
				dp[j][i] = (int) (sum % v);

				if (i == steps - 1) {
					return dp[j][i];
				}
			}
		}


		return dp[0][steps - 1];
	}
}
