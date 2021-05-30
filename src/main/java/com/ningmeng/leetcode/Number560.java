package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-05-30 21:43:16
 * @Version 1.0
 */
public class Number560 {

	public static void main(String[] args) {
		System.out.println(subarraySum(new int[]{1, 1, 1}, 2));
	}

	public static int subarraySum(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<>();

		map.put(0, 1);
		int count = 0;
		int pre = 0;
		for(int i : nums) {
			pre += i;
			if (map.containsKey(pre - k)) {
				count += map.get(pre - k);
			}
			map.put(pre, map.getOrDefault(pre, 0) + 1);
		}

		return count;
	}
}
