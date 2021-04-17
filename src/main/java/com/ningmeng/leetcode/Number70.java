package com.ningmeng.leetcode;

/**
 * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 注意：给定 n 是一个正整数。
 *
 * 示例 1：
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/climbing-stairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * @Author ningmengmao
 * @Date 2021-04-11 19:56:03
 * @Version 1.0
 */
public class Number70 {
	public static void main(String[] args) {


		System.out.println(climbStairs(10));


	}

	public static int climbStairs(int n) {
		if (n < 2) {
			return Math.min(n + 1, 1);
		}

		int[] dp = new int[n];

		dp[0] = 0;
		dp[1] = 1;
		// f(n) = f(n-1) + f(n-2)
		// f(n) 为跳到n阶的方法数

		for (int i = 2; i < n; i++) {
			dp[i] = dp[i - 1] + dp[i -2];
		}

		return dp[n-1] + dp[n-2];


		/*
		int a = 1;
		int b = 1;
		// f(n) = f(n-1) + f(n-2)
		// f(n) 为跳到n阶的方法数

		for (int i = 2; i < n; i++) {
			int temp = a + b;
			a = b;
			b = temp;
		}

		return a + b;
		 */
	}
}
