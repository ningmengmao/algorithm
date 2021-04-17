package com.ningmeng.leetcode;

import java.util.Stack;

/**
 * @Author ningmengmao
 * @Date 2021-04-02 22:57:53
 * @Version 1.0
 */
public class Number1021 {

	public static void main(String[] args) {
		Solution solution = new Solution();
		String s = solution.removeOuterParentheses("(()())(())(()(()))");
		System.out.println(s);
	}

	static class Solution {

		public String removeOuterParentheses(String s) {
			StringBuffer sb = new StringBuffer();
			int left = 0;
			for (char c : s.toCharArray()) {
				if (c == '(' && left++ > 0)
					sb.append('(');
				if (c == ')' && --left > 0)
					sb.append(')');
			}

			return sb.toString();
		}
	}

}


