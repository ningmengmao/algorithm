package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-24 19:24:56
 * @Version 1.0
 */
public class Number377 {

	public static void main(String[] args) {

		int[] arr= {9};

		System.out.println(combinationSum4(arr, 3));
	}

	/**
	 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
	 *
	 * 题目数据保证答案符合 32 位整数范围。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/combination-sum-iv
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int combinationSum4(int[] nums, int target) {

		// f(n) 和为n有多少种组合
		int[] dp = new int[target + 1];

		for (int j : nums) {
			if (j <= target) {
				dp[j] = 1;
			}
		}

		// f(n) = sum(f[n- num[i]])

		for (int i = 1; i <= target; i++) {
			int sum = dp[i];

			for (int num : nums) {
				if (i - num >= 0) {
					sum += dp[i - num];
				}
			}
			dp[i] = sum;
		}

		return dp[target];
	}
}
