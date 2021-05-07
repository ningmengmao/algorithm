package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-07 12:38:38
 * @Version 1.0
 */
public class Number338 {

	public static void main(String[] args) {
		int[] arr = countBits(10);
		System.out.println(Arrays.toString(arr));
	}

	public static int[] countBits(int num) {
		int[] dp = new int[num + 1];

		dp[0] = 0;

		int highBit = 0;
		for(int i = 1; i < num + 1; i++) {
			if (i == 1) {
				dp[i] = 1;
			} else {
				// double pow = Math.log(i) / Math.log(2);
				// int f = (int) Math.pow(2, (int)pow);
				// dp[i] = 1 + dp[i - f];

				// 1000 & 0111 == 0
				if ((i & (i - 1)) == 0) {
					highBit = i;
				}
				dp[i] = 1 + dp[i - highBit];

			}
		}

		return dp;
	}
}
