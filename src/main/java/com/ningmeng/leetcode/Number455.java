package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-06-06 19:54:51
 * @Version 1.0
 */
public class Number455 {


	public int findContentChildren(int[] g, int[] s) {
		Arrays.sort(g);
		Arrays.sort(s);

		int res = 0;
		int l = 0;
		int r = 0;

		while( l < s.length && r < g.length) {
			if (s[l] >= g[r]){
				res++;
				l++;
				r++;
			} else {
				l++;
			}
		}
		return res;
	}
}
