package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-05 21:57:50
 * @Version 1.0
 */
public class Number1365 {

	public static void main(String[] args) {
		Number1365 number1365 = new Number1365();
	}

	public int[] smallerNumbersThanCurrent(int[] nums) {

		int[] result = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			result[i] = nums[i];
		}

		int parent = (nums.length - 1 - 1) / 2;

		for(int i = parent; i >= 0; i--) {
			toHeap(nums, i, nums.length);
		}

		for(int i = nums.length - 1; i >= 0; i--) {
			swap(nums, 0, i);
			toHeap(nums, 0, i);
		}

		for (int i = 0; i < nums.length; i++) {
			for (int j=0; j < nums.length; j++) {
				if (result[i] == nums[j]) {
					result[i] = j;
					break;
				}
			}
		}

		return result;


	}


	public void toHeap(int[] arr, int parent, int len) {

		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < len && arr[lc] > arr[parent]) {
			swap(arr, lc, parent);
			toHeap(arr, lc, len);
		}

		if (rc < len && arr[rc] > arr[parent]) {
			swap(arr, rc, parent);
			toHeap(arr, rc, len);
		}

	}


	public void swap(int[] arr, int f, int s) {
		int temp = arr[f];
		arr[f] = arr[s];
		arr[s] = temp;

	}
}
