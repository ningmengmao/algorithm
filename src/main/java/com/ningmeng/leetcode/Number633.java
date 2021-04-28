package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-28 09:31:11
 * @Version 1.0
 */
public class Number633 {

	public boolean judgeSquareSum(int c) {

		for (long a = 0; a * a <= c ; a++) {
			double b = Math.sqrt(c - a * a);
			if (b == (int) b) {
				return true;
			}
		}
		return false;
	}
}
