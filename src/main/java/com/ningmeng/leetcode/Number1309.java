package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 22:53:27
 * @Version 1.0
 */
public class Number1309 {

	public static void main(String[] args) {
		System.out.println(freqAlphabets("10#11#12"));
	}

	public static String freqAlphabets(String s) {
		int index = s.length() - 1;
		String res = "";
		while(index > -1) {
			if (s.charAt(index) != '#') {
				char i = (char) ('a' + (s.charAt(index) - '0') - 1);
				res = i + res;
				index-- ;
			} else {
				char i = (char) ('a' - 1 + (Integer.parseInt(s.substring(index - 2, index))));
				res = i + res;
				index -= 3;

			}
		}

		return res;

	}
}
