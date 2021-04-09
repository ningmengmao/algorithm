package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-03 11:44:23
 * @Version 1.0
 */
public class Number1512 {

	public static void main(String[] args) {
		int[] arr = {1,2,3,1,1,3};
		int[] shuffle = shuffle(arr, 3);
		System.out.println(Arrays.toString(shuffle));
	}


	public static int[] shuffle(int[] nums, int n) {
		int[] result = new int[2 * n];

		int index =0;
		for(int i=0, j = n; i< n && j < 2*n; i++, j++) {
			result[index++] = nums[i];
			result[index++] = nums[j];
		}
		return result;
	}

	private static int sum(int[] nums) {
		int[] radix = new int[100];
		int result = 0;
		for (int i = nums.length - 1; i >= 0 ; i--) {
			int index = nums[i] - 1;
			radix[index] += 1;
			result += (radix[index] - 1);
		}

		return result;
	}


}
