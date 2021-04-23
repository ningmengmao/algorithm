package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-23 09:25:50
 * @Version 1.0
 */
public class Number368 {

	/*
	 给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，
	 子集中每一元素对 (answer[i], answer[j]) 都应当满足：
	 answer[i] % answer[j] == 0 ，或
	 answer[j] % answer[i] == 0
	 如果存在多个有效解子集，返回其中任何一个均可。

	 示例 1：
	 输入：nums = [1,2,3]
	 输出：[1,2]
	 解释：[1,3] 也会被视为正确答案。
	 示例 2：
	 输入：nums = [1,2,4,8]
	 输出：[1,2,4,8]
	 来源：力扣（LeetCode）
	 链接：https://leetcode-cn.com/problems/largest-divisible-subset
	 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	public List<Integer> largestDivisibleSubset(int[] nums) {

		int[] dp = new int[nums.length];
		int[] way = new int[nums.length];


		// 排序列表
		Arrays.sort(nums);

		// f(n)就是有子集的长度
		// f(n) = max( num[n] % num[i] == 0 ? f(i) + 1 : 1)

		int m = 1;
		int mIndex = 0;
		for (int i = 0; i < nums.length; i++) {
			dp[i] = 1;
			int max = 1;
			int last = -1;
			for (int j = 0; j < i; j++) {
				if ( nums[i] % nums[j] == 0 && dp[j] + 1 > max) {
					max = dp[j] + 1;
					last = j;
					dp[i] = max;
				}
			}
			way[i] = last;
			if (dp[i] > m) {
				m = dp[i];
				mIndex = i;
			}
		}

		LinkedList<Integer> res = new LinkedList<>();

		while (true) {
			res.add(nums[mIndex]);
			mIndex = way[mIndex];
			if (mIndex == -1) {
				break;
			}
		}

		return res;
	}


	public static void main(String[] args) {
		int[] arr = {1,2,3,5,7,9,11,8,6,15,30,25,44,50,65};
		Number368 main = new Number368();
		List<Integer> res = main.largestDivisibleSubset(arr);
		for (Integer r : res) {
			System.out.print(r + "\t");
		}
	}
}
