package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 09:18:21
 * @Version 1.0
 */
public class Number27 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,2,3,0,4,2};
		System.out.println(removeElement(arr, 0));
		System.out.println(Arrays.toString(arr));
	}
	public static int removeElement(int[] nums, int val) {
		if (nums.length == 0) {
			return 0;
		}
		int last = nums.length - 1;
		int res = nums.length;
		// 先找到和val相等的
		// 找到后在从后往前找一个和 val不等的

		for (int j = last; j >=0 ; j--) {
			if (nums[j] == val) {
				for (int i = nums.length - 1; i > j; i--) {
					if(nums[i] != val) {
						nums[j] = nums[i];
						nums[i] = val;
						break;
					}
				}
				res--;
			}
		}
		return res;

	}
}
