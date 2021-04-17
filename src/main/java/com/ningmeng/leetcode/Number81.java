package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-07 09:18:25
 * @Version 1.0
 */
public class Number81 {


	public static void main(String[] args) {
		Number81 number31 = new Number81();

		int[] arr = {1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1};
		System.out.println(number31.search(arr, 13));
	}

	public boolean search(int[] nums, int target) {

		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i-1]) {
				index = i;
				break;
			}
		}

		int[] temp = new int[nums.length];

		for (int i = 0; i < temp.length; i++) {
			temp[i] = nums[index];
			if (index + 1 == nums.length) {
				index = 0;
			} else {
				index++;
			}
		}

		return search(temp, target, 0, nums.length - 1);
	}


	public boolean search(int[] arr, int target, int start, int end) {
		if (start == end) {
			return target == arr[start];
		} else if (end - start == 1) {
			return arr[start] == target || arr[end] == target;
		}

		int mid = (start + end) / 2;

		if (arr[mid] == target) {
			return true;
		} else if (arr[mid] < target) {
			return search(arr, target, mid, end);
		} else {
			return search(arr, target, start, mid);
		}

	}

}
