package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 17:38:27
 * @Version 1.0
 */
public class MST0106 {
	public String compressString(String S) {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		while( i < S.length()) {
			char c = S.charAt(i);
			sb.append(S.charAt(i));
			int count = 1;
			int j = i + 1;
			for(; j < S.length(); j++) {
				if(S.charAt(j) == c) {
					count++;
				} else {
					break;
				}
			}
			sb.append(count);

			i = j;
		}
		if (sb.length() < S.length()) {
			return sb.toString();
		} else {
			return S;
		}

	}
}
