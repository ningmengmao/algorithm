package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-29 09:23:40
 * @Version 1.0
 */
public class Number403 {

	public boolean canCross(int[] stones) {
		int len = stones.length;
		boolean[][] dp = new boolean[len][len];
		dp[0][0] = true;

		for (int i = 1; i < len; i++) {
			for (int j = 0; j < i; j++) {
				int x = stones[i] - stones[j];
				if ( x <= i && x >= 0 ) {
					if (x - 1 >= 0) {
						dp[i][x] = dp[i][x] || dp[j][x - 1];
					}
					dp[i][x] = dp[i][x] || dp[j][x];
					if (x + 1 <= i) {
						dp[i][x] = dp[i][x] ||dp[j][x+1];
					}
				}
			}
		}

		for (int i = 0; i < len; i++) {
			if (dp[len - 1][i]) {
				return true;
			}
		}
		return false;
	}

}
