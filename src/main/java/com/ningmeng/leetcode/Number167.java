package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-09 22:04:16
 * @Version 1.0
 */
public class Number167 {

	public static void main(String[] args) {
		var arr = new int[] {-1, 0};
		System.out.println(Arrays.toString(twoSum(arr, -1)));
	}

	public static int[] twoSum(int[] numbers, int target) {

		int l = 0;
		int r = numbers.length - 1;

		while (l < r - 1) {

			int mid = (r - l + 1) / 2 + l;

			if (numbers[mid] == target) {
				l = mid;
				break;
			} else if (numbers[mid] > target) {
				r = mid;
			} else {
				l = mid;
			}
		}

		if (numbers[l] == target) {
			r = l + 1;
			l = 0;
		} else if (target - numbers[l] >= numbers[l + 1] - target) {
			l = 0;
			r = r;
		} else {
			l = 0;
			r = l + 1;
		}


		int[] res = {-1 , -1};

		while (l < r) {
			if (numbers[l] + numbers[r] == target) {
				res[0] = l;
				res[1] = r;
				return res;
			} else if (numbers[l] + numbers[r] > target) {
				r --;
			} else {
				l ++;
			}
		}

		return res;

	}
}
