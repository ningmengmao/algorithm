package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 14:02:35
 * @Version 1.0
 */
public class Number1796 {

	public int secondHighest(String s) {

		boolean[] arr = new boolean[10];
		for(char c : s.toCharArray()) {
			if ( (c - '0' >= 0) && ('9' - c >= 0)) {
				arr[c - '0'] = true;
			}
		}
		boolean f = false;

		for (int i = 9; i >=0; i--) {
			if(arr[i] && !f) {
				f = true;
			} else if (arr[i] && f) {
				return i;
			}
		}
		return -1;

	}
}
