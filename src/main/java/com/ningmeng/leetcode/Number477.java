package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-28 17:14:47
 * @Version 1.0
 */
public class Number477 {

	public int totalHammingDistance(int[] nums) {
		int ans = 0, n = nums.length;
		for (int i = 0; i < 30; ++i) {
			int c = 0;
			for (int val : nums) {
				c += (val >> i) & 1;
			}
			ans += c * (n - c);
		}
		return ans;
	}

}
