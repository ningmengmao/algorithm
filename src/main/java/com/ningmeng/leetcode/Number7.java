package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-03 14:55:20
 * @Version 1.0
 */
public class Number7 {

	public int reverse(int x) {

		String str = String.valueOf(x);
		if (str.length() == 1) {
			return x;
		}
		if (str.length() == 2 && str.charAt(0) == '-') {
			return x;
		}

		StringBuilder sb = new StringBuilder();

		int start = 0;
		if (str.charAt(0) == '-') {
			start = 1;
			sb.append('-');
		}

		for(int i = str.length() - 1; i >= start; i--) {
			sb.append(str.charAt(i));
		}

		int res = 0;
		try {
			res = Integer.parseInt(sb.toString());
		} catch(Exception ignored) {
		}

		return res;

	}
}
