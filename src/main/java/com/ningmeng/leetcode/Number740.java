package com.ningmeng.leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-05 12:55:31
 * @Version 1.0
 */
public class Number740 {


	/*
	 * 给你一个整数数组 nums ，你可以对它进行一些操作。

	 * 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] + 1 的元素。
	 * 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。

	 * 示例 1：
	 * 输入：nums = [3,4,2]
	 * 输出：6
	 * 删除 4 获得 4 个点数，因此 3 也被删除。
	 * 之后，删除 2 获得 2 个点数。总共获得 6 个点数。
	 * 示例 2：
	 *
	 * 输入：nums = [2,2,3,3,3,4]
	 * 输出：9
	 * 删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
	 * 之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
	 * 总共获得 9 个点数。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/delete-and-earn
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	/*
	 * input -> 3, 4, 2, 2, 4, 3
	 * 将输入处理成数组, 下标为对应的数字, 值为出现的次数
	 * 输入经过处理后 {0,0,2,2,2}
	 *
	 * input -> 1,2,3,5,5,6,7
	 * {0, 1, 1, 1, 0, 2, 1, 1}
	 * f(n) 第n个数最好的结果
	 * f(n) = max(f(n-1), f(n-2) + n * i);
	 */

	public static int deleteAndEarn(int[] nums) {
		HashMap<Integer, Integer> bucket = new HashMap<>();

		for (int i : nums) {
			bucket.merge(i, 1, Integer::sum);
		}

		int[] dp = new int[(int) Math.pow(10, 4)];

		int max = bucket.entrySet().stream()
				.max(Comparator.comparingInt(Map.Entry::getKey))
				.map(Map.Entry::getKey).orElseThrow();

		for (int j = 1; j <= max; j++) {
			int i = bucket.getOrDefault(j, 0);
			if (j == 1) {
				dp[j] = i * j;
			} else {
				dp[j] = Math.max(dp[j - 1], dp[j - 2] + i * j);
			}
		}



//		bucket.entrySet().stream()
//				.sorted(Comparator.comparingInt(Map.Entry::getKey))
//				.forEach(e -> {
//					int n = e.getKey();
//					int i = e.getValue();
//					if (n == 1) {
//						dp[n] = i * n;
//					} else {
//						dp[n] = Math.max(dp[n - 1], dp[n - 2] + i * n);
//					}
//					last = n;
//				});

		return dp[max];

	}

	public static void main(String[] args) {
		int[] arr = {3,4,2,5,6,7,8,9,11,13,22,12,21,25};
		System.out.println(deleteAndEarn(arr));
	}
}
