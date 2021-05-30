package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-31 07:37:34
 * @Version 1.0
 */
public class Number342 {

	public boolean isPowerOfFour(int n) {

		if (n <= 0) {
			return false;
		} else if (n == 1) {
			return true;
		} else if ((n & (n - 1)) == 0) {
//			String s = Integer.toBinaryString(n);
//			return s.length() % 2 == 1;

			return n % 3 == 1;
		}

		return false;
	}
}
