package com.ningmeng.leetcode;

import java.util.function.Predicate;

/**
 * @Author ningmengmao
 * @Date 2021-04-21 09:06:51
 * @Version 1.0
 */
public class Number91 {

	public static void main(String[] args) {
		Number91 main = new Number91();
		System.out.println(main.numDecodings("226"));
	}

	public int numDecodings(String s) {
		if (s.charAt(0) == '0'){
			return 0;
		}
		int[] res = new int[s.length()];
		res[0] = 1;

		Predicate<String> predicate = str -> Integer.parseInt(str) < 27 && Integer.parseInt(str) > 9;

		// f(n) = f(n-1) + f(n-2) if (charAt( n-1) + charAt(n) 小于27 and 大于9)
		for (int i = 1; i < s.length(); i++) {
			int sum = 0;
			if (s.charAt(i) != '0') {
				sum += res[i - 1];
			}
			if (i - 2 >= 0 && predicate.test(s.substring(i - 1, i + 1))) {
				sum += res[i-2];
			} else if (i - 2 == -1 && predicate.test(s.substring(0, 2))) {
				sum += 1;
			}
			res[i] = sum;
		}

		return res[s.length() - 1];
	}
}
