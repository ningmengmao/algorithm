package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-06 10:05:53
 * @Version 1.0
 */
public class Number392 {

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
	}

	public static boolean isSubsequence(String s, String t) {
		if (s == "") {
			return true;
		}
		if (t.length() < s.length()) {
			return false;
		}

		String[] dp = new String[t.length()];

		int index = 0;

		StringBuilder sb = new StringBuilder();
		if (t.charAt(0) == s.charAt(0)) {
			sb.append(t.charAt(0));
		}
		dp[0] = sb.toString();
		if (!"".equals(dp[0])) {
			index++;
		}


		for( int i = 1; i < t.length(); i++) {
			if (index < s.length()) {
				if (t.charAt(i) == s.charAt(index)) {
					dp[i] = sb.append(s.charAt(index)).toString();
					index++;
				} else {
					dp[i] = dp[i - 1];
				}
			} else {
				dp[i] = dp[i - 1];
			}
		}

		return dp[t.length() - 1].equals(s);
	}
}
