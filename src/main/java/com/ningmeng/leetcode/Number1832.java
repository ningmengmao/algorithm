package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-26 09:34:25
 * @Version 1.0
 */
public class Number1832 {

	public boolean checkIfPangram(String sentence) {
		boolean[] arr = new boolean[26];

		for(char c : sentence.toCharArray()) {
			arr[c - 'a'] = true;
		}

		for(boolean b : arr) {
			if (!b) {
				return false;
			}
		}
		return true;


	}
}
