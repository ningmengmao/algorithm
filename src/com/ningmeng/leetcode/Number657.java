package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 22:43:11
 * @Version 1.0
 */
public class Number657 {
	public boolean judgeCircle(String moves) {

		if (moves.length() % 2 != 0) {
			return false;
		}

		int[] arr = new int[4];
		char[] f = {'U', 'D', 'L', 'R'};

		for (char c: moves.toCharArray()) {
			for(int i = 0; i< 4; i++) {
				if (f[i] == c) {
					arr[i] ++;
					break;
				}
			}
		}

		if (arr[0] == arr[1] && arr[2] == arr[3]) {
			return true;
		}

		return false;
	}
}
