package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-13 22:16:19
 * @Version 1.0
 */
public class Number1833 {

	/**
	 * 每次取最小的,则结果的数必定最多
	 * @param costs
	 * @param coins
	 * @return
	 */

	public int maxIceCream(int[] costs, int coins) {
		Arrays.sort(costs);
		int res = 0;

		for(int i : costs) {
			if (coins - i >= 0) {
				res += 1;
				coins -= i;
			} else {
				break;
			}
		}

		return res;
	}
}
