package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-01 21:59:00
 * @Version 1.0
 */
public class Number35 {

	public int searchInsert(int[] nums, int target) {
		int l = 0;
		int r = nums.length - 1;
		while(l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target > nums[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return l;
	}
}
