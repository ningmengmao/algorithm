package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 22:51:48
 * @Version 1.0
 */
public class Number1768 {


	public String mergeAlternately(String word1, String word2) {

		StringBuilder sb =  new StringBuilder();

		int len = Math.min(word1.length(), word2.length());

		for(int i = 0; i < len ; i++) {
			sb.append(word1.charAt(i));
			sb.append(word2.charAt(i));
		}

		// 下面两个if最多触发一个
		if (word1.length() > len) {
			sb.append(word1.substring(len));
		}
		if (word2.length() > len) {
			sb.append(word2.substring(len));
		}

		return sb.toString();
	}
}
