package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-09 11:13:57
 * @Version 1.0
 */
public class Number1482 {
	public static void main(String[] args) {
		var main = new Number1482();

		var arr = new int[]{97, 83};
		main.minDays(arr, 2, 1);
	}

	public int minDays(int[] bloomDay, int m, int k) {
		if (m * k > bloomDay.length) {
			return -1;
		}

		int l = Integer.MAX_VALUE;
		int r = Integer.MIN_VALUE;
		for (int i : bloomDay) {
			l = Math.min(l, i);
			r = Math.max(r, i);
		}

		while (l < r) {
			int mid = (l + r) / 2;
			if (can(bloomDay, m, k, mid)) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}

		return l;

	}

	/**
	 * 判断是否能制作成m束花
	 * @param bloomDay 输入数组
	 * @param m 目标数
	 * @param k 连续的花数
	 * @param day 当前天数
	 * @return 是否成立
	 */
	private boolean can(int[] bloomDay, int m, int k, int day) {
		int totalBloom = 0;
		int flowers = 0;

		for(int i : bloomDay) {
			if (i <= day) {
				flowers++;
				if (flowers  == k) {
					totalBloom++;
					flowers = 0;
				}
			} else {
				flowers = 0;
			}
		}

		return totalBloom >= m;

	}
}
