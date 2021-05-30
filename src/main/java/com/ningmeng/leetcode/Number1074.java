package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-29 19:19:07
 * @Version 1.0
 */
public class Number1074 {

	public static void main(String[] args) {
		var arr = new int[][] {
				{0,1,0},
				{1,2,2},
				{0,1,0}
		};
		var main = new Number1074();
		System.out.println(main.numSubmatrixSumTarget(arr, 0));
	}

	public int numSubmatrixSumTarget(int[][] matrix, int target) {
		int ans = 0;
		// m是x, n是y
		int m = matrix.length, n = matrix[0].length;

		// 从第一行开始
		// 0,0 -> 0,1 -> 0,2
		// 1,1 -> 1,2
		// 2,2
		for (int i = 0; i < m; ++i) { // 枚举上边界
			int[] sum = new int[n];
			for (int j = i; j < m; ++j) { // 枚举下边界
				for (int c = 0; c < n; ++c) {
					sum[c] += matrix[j][c]; // 更新每列的元素和
				}
				ans += subarraySum(sum, target);
			}
		}
		return ans;
	}

	public int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int count = 0, pre = 0;
		for (int x : nums) {
			pre += x;
			if (map.containsKey(pre - k)) {
				count += map.get(pre - k);
			}
			map.put(pre, map.getOrDefault(pre, 0) + 1);
		}
		return count;
	}


}
