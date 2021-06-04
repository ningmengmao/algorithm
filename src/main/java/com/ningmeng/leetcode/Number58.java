package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-04 20:44:14
 * @Version 1.0
 */
public class Number58 {
	public int lengthOfLastWord(String s) {
		int count = 0;
		boolean f = false;
		for(int i = s.length() - 1; i >=0 ; i--) {
			if (s.charAt(i) != ' ') {
				count ++;
				f = true;
			} else if (f) {
				break;
			}
		}
		return count;
	}
}
