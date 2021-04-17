package com.ningmeng.leetcode;

import java.util.HashSet;

/**
 * @Author ningmengmao
 * @Date 2021-04-11 17:37:20
 * @Version 1.0
 */
public class Number264 {

	public static void main(String[] args) {
		Number264 number264 = new Number264();

		int i = number264.nthUglyNumber(1690);
	}

	// todo: 用动态规划做
	public int nthUglyNumber(int n) {

		int[] result = new int[n];

		long[] num = {2,3,5};

		result[0] = 1;


		for (int i = 1; i < n ; i++) {
			int target = Integer.MAX_VALUE;

			for (int k = 0; k < i; k ++) {
				for (long j:num) {
					if (result[k] * j > result[i - 1]) {
						target = (int) Math.min(result[k] * j, target);
					}
				}
			}

			result[i] = target;
		}


		HashSet<Integer> integers = new HashSet<>(n);

		for (int i : result) {
			if (integers.contains(i)) {
				System.out.println(i);
			} else {
				integers.add(i);
			}
		}
		return result[n-1];

	}






}
