package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-22 19:48:18
 * @Version 1.0
 */
public class Number1137 {

	/**
	 * 第 N 个泰波那契数
	 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
	 */
	public int tribonacci(int n) {
		if (n == 0) {
			return 0;
		} else if (n == 1){
			return 1;
		} else if (n == 2) {
			return 1;
		}

		int res = 0;
		int a = 0;
		int b = 1;
		int c = 1;
		for(int i = 3; i <= n; i++) {
			res = a + b + c;
			a = b;
			b = c;
			c = res;
		}
		return res;
	}
}
