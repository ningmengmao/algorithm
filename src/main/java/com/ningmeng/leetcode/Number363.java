package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 09:25:57
 * @Version 1.0
 */
public class Number363 {

	/**
	 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
	 *
	 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k
	 * @param matrix
	 * @param k
	 * @return
	 */

	public int maxSumSubmatrix(int[][] matrix, int k) {

		// f(x,y) = f(x-1,y) + f(x,y-1) + matrix[x][y] - f(x-1,y-1)
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				int[][] dp = new int[m][n];
				dp[0][0] = matrix[i][j];

				// 求dp(n)
				for (int l = i; l < m; l++) {
					for (int o = j; o < n; o++) {
						int x1y = 0;
						if (l - 1 - i >= 0) {
							x1y = dp[l - 1 - i][o - j];
						}
						int xy1 = 0;
						if (o - j - 1 >= 0) {
							xy1 = dp[l - i][o - j - 1];
						}
						int x1y1 = 0;
						if (l - i - 1 >=0 && o - j -1 >= 0) {
							x1y1 = dp[l - i - 1][o-j - 1];
						}
						dp[l - i][o - j] = x1y + xy1  + matrix[i][j] -x1y1;
					}
				}


			}
		}

		// todo 未完成
		return 0;
	}
}
