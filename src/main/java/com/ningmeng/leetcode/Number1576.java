package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 18:07:33
 * @Version 1.0
 */
public class Number1576 {

	public static void main(String[] args) {
		System.out.println(modifyString("??s"));
	}

	public static String modifyString(String s) {
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) != '?') {
				sb.append(s.charAt(i));
			} else {

				char before = 'a' - 1;
				char next = 'z' + 1;
				if ( i > 0) {
					before = sb.charAt(i - 1);
				}
				if (i < s.length() - 1) {
					next = s.charAt(i + 1);
				}
				char c = 'a';
				while(true) {
					if (c != next && c != before) {
						sb.append(c);
						break;
					} else {
						c = (char) (c + 1);
					}
				}
			}
		}
		return sb.toString();


	}
}
