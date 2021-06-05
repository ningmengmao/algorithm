package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-05 10:23:34
 * @Version 1.0
 */
public class JZ10I {

	public int fib(int n) {
		if (n < 2) {
			return n;
		}

		int c = 0;
		int a = 0;
		int b = 1;
		for (int i = 2; i <= n; i ++) {
			c = (a + b) % 1000000007;
			a = b;
			b = c;
		}

		return c;
	}
}
