package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-29 22:03:58
 * @Version 1.0
 */
public class Number1342 {

	public static void main(String[] args) {
		int i = numberOfSteps(8);
	}

	public static int numberOfSteps(int num) {
		if (num == 1) {
			return 1;
		}
		String s = Integer.toBinaryString(num);
		return s.length() +  s.substring(1).replace("0", "").length() - 1;
	}

	public int numberOfSteps2(int num) {
		int res = 0;
		while (num > 0) {
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num -= 1;
			}
			res++;
		}
		return res;
	}
}
