package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-19 21:28:31
 * @Version 1.0
 */
public class Number1824 {

	public static void main(String[] args) {
		var main = new Number1824();
		var i = main.minSideJumps(new int[]{0,1,2,3,2,3,1,3,3,2,2,1,1,2,3,3,2,1,1,0,0,3,2,0,1,0});
//		var i = main.minSideJumps(new int[]{0, 1, 2, 3, 1, 2, 3, 0});
	}

	public int minSideJumps(int[] obstacles) {
		int[][] dp = new int[2][3];
		dp[0] = new int[] {1,0,1};

		for (int i = 1; i < obstacles.length; i++) {

			for (int j = 0; j < dp[0].length; j++) {
				if (j != obstacles[i] - 1) {
					dp[1][j] = dp[0][j];
				} else {
					dp[1][j] = Integer.MAX_VALUE - 10000;
				}
			}

			if (obstacles[i] != 1) {
				dp[1][0] = min(dp[1][0], dp[1][1] + 1, dp[1][2] + 1);
			}
			if (obstacles[i] != 2) {
				dp[1][1] = min(dp[1][0] + 1, dp[1][1], dp[1][2] + 1);
			}
			if (obstacles[i] != 3) {
				dp[1][2] = min(dp[1][0] + 1,dp[1][1] + 1, dp[1][2]);

			}

			dp[0] = dp[1];
		}


		return Math.min(dp[1][0], Math.min(dp[1][1], dp[1][2]));
	}


	private int min(int x, int y, int z) {
		return Math.min(x, Math.min(y, z));
	}
}
