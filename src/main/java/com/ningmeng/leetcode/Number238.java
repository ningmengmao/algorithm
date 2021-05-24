package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-24 21:14:40
 * @Version 1.0
 */
public class Number238 {

	// res[i] 就是左边的乘右边的
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];

		int l = 1;
		res[0] = 1;
		// 左边的
		for (int i = 1; i < res.length; i++) {
			l *= nums[i - 1];
			res[i] = l;
		}

		int r = 1;

		// 右边的
		for(int i = res.length - 2; i >= 0 ;i--) {
			r = nums[i + 1] * r;
			res[i] = r * res[i];
		}



		return res;
	}
}
