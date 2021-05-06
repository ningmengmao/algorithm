package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-05 20:52:52
 * @Version 1.0
 */
public class Number852 {

	public static void main(String[] args) {
		int[] arr = {0,1,2,3,4,3,2};
		System.out.println(search(arr, 0, arr.length));
	}

	private static int search(int[] arr, int start, int end) {

		if (start == end) {
			return start;
		}

		int mid = (start + end) / 2;

		if (arr[mid] < arr[mid + 1]) {
			return search(arr, mid + 1, end);
		} else {
			return search(arr, start, mid);
		}

	}
}
