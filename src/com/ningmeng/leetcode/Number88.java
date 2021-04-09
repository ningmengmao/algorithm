package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-05 18:52:16
 * @Version 1.0
 */
public class Number88 {


	public static void main(String[] args) {
		Number88 number88 = new Number88();

		int[] first = {1,2,5,0,0};
		int[] s = {4,5};
		number88.merge(first, 3, s, 2);
		System.out.println(Arrays.toString(first));
	}


	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int last = m + n - 1;
		m -= 1;
		n -= 1;
		int current;

		while (m > -1 || n > -1) {
			if (m == -1) {
				current = nums2[n--];
			} else if ( n == -1) {
				current = nums1[m--];
			} else if (nums1[m] > nums2[n]) {
				current = nums1[m--];
			} else {
				current = nums2[n--];
			}
			nums1[last--] = current;
		}

	}
}
