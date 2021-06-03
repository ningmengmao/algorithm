package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-06-03 21:42:32
 * @Version 1.0
 */
public class Number525 {

	public int findMaxLength(int[] nums) {

		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;

		int res = 0;
		map.put(0, -1);
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == 1) {
				count++;
			} else {
				count--;
			}
			if (map.containsKey(count)) {
				int pre = map.get(count);
				res = Math.max(res, i - pre);
			} else {
				map.put(count, i);
			}
		}
		return res;

	}
}
