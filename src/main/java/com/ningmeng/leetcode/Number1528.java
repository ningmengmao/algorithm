package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 14:09:05
 * @Version 1.0
 */
public class Number1528 {
	public String restoreString(String s, int[] indices) {
		char[] arr = new char[indices.length];

		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int index = indices[i];
			arr[index] = c;
		}

		return new String(arr);
	}
}
