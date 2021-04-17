package com.ningmeng.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 14:18:44
 * @Version 1.0
 */
public class Number220 {

	public static void main(String[] args) {
		Number220 n = new Number220();
		int[] arr = {1,5,9,1,5,9};
		System.out.println(n.containsNearbyAlmostDuplicate(arr, 2, 3));
	}


	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int n = nums.length;
		Map<Long, Long> map = new HashMap<>();
		// 桶的范围
		long w = (long) t + 1;
		for (int i = 0; i < n; i++) {
			long id = getID(nums[i], w);
			if (map.containsKey(id)) {
				return true;
			}
			if (map.containsKey(id - 1) && Math.abs(nums[i] - map.get(id - 1)) < w) {
				return true;
			}
			if (map.containsKey(id + 1) && Math.abs(nums[i] - map.get(id + 1)) < w) {
				return true;
			}
			map.put(id, (long) nums[i]);
			if (i >= k) {
				map.remove(getID(nums[i - k], w));
			}
		}
		return false;
	}

	public long getID(long x, long w) {
		if (x >= 0) {
			return x / w;
		}
		return (x + 1) / w - 1;
	}

}
