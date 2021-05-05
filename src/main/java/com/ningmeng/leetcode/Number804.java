package com.ningmeng.leetcode;

import java.util.HashSet;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 21:56:17
 * @Version 1.0
 */
public class Number804 {

	public static void main(String[] args) {
		String[] arr = {"gin", "zen", "gig", "msg"};
		uniqueMorseRepresentations(arr);
	}

	public static int uniqueMorseRepresentations(String[] words) {
		String[] base = new String[]{".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

		HashSet<String> set = new HashSet<>();


		for(String str : words) {
			StringBuilder s = new StringBuilder();
			for(char c : str.toCharArray()) {
				s.append(base[c - 'a']);
			}

			set.add(s.toString());
		}

		return set.size();
	}
}
