package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 13:11:11
 * @Version 1.0
 */
public class Number1704 {
	public static void main(String[] args) {

		boolean b = halvesAreAlike("AbCdEfGh");
		System.out.println(b);
	}

	public static boolean halvesAreAlike(String s) {
		s = s.toLowerCase();
		HashSet<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
		int count = 0;

		for (int i = 0; i < s.length() / 2; i++) {
			if (set.contains(s.charAt(i))) {
				count++;
			}
		}

		for (int i = s.length() / 2; i < s.length(); i++) {
			if (set.contains(s.charAt(i))) {
				count--;
			}
		}

		return count == 0;

	}
}
