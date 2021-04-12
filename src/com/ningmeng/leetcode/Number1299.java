package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 22:16:12
 * @Version 1.0
 */
public class Number1299 {

	public int[] replaceElements(int[] arr) {
		if (arr.length == 1) {
			return new int[] {-1};
		}

		int[] dp = new int[arr.length];
		int len = arr.length;
		dp[len - 1] = -1;

		for(int i = len - 2; i>=0; i--) {
			dp[i] = Math.max(dp[i+1], arr[i + 1]);
		}

		System.arraycopy(dp, 0, arr, 0, len);

		return arr;
	}
}
