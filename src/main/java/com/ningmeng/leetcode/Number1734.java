package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-11 14:18:50
 * @Version 1.0
 */
public class Number1734 {
	public int[] decode(int[] encoded) {
		int n = encoded.length + 1;
		int total = 0;
		for (int i = 1; i <= n; i++) {
			total ^= i;
		}
		int odd = 0;
		for (int i = 1; i < n - 1; i += 2) {
			odd ^= encoded[i];
		}
		int[] perm = new int[n];
		perm[0] = total ^ odd;
		for (int i = 0; i < n - 1; i++) {
			perm[i + 1] = perm[i] ^ encoded[i];
		}
		return perm;
	}
}
