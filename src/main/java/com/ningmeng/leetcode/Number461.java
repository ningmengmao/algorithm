package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-27 09:01:45
 * @Version 1.0
 */
public class Number461 {

	public static void main(String[] args) {
		System.out.println(hammingDistance(1, 4));
	}

	public static int hammingDistance(int x, int y) {
		int r = x ^ y;
		int res = 0;
		while(r > 0) {
			if ((r & 1) == 1) {
				res ++;
			}
			r >>= 1;
		}

		return res;
	}
}
