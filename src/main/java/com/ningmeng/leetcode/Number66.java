package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-01 21:24:58
 * @Version 1.0
 */
public class Number66 {

	public int[] plusOne(int[] digits) {
		int last = digits.length - 1;
		if (digits[last] < 9) {
			digits[last] += 1;
			return digits;
		}

		digits[last] += 1;
		for (int i = digits.length - 1; i >= 1; i--) {
			if (digits[i] >= 10) {
				digits[i - 1] += 1;
				digits[i] -= 10;
			}
		}

		if (digits[0] <= 9) {
			return digits;
		} else {
			int[] res = new int[digits.length + 1];
			res[0] = 1;
			res[1] = digits[0] - 10;
			for (int i = 2; i < digits.length; i++) {
				res[i] = digits[i];
			}
			return res;
		}
	}
}
