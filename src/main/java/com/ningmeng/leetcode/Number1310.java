package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-12 09:01:23
 * @Version 1.0
 */
public class Number1310 {

	public static void main(String[] args) {
		var arr = new int[]{4,8,2,10};
		var arr2 = new int[][] {
				{2,3},
				{1,3},
				{0,0},
				{0,3}
		};
		System.out.println(Arrays.toString(xorQueries(arr, arr2)));
	}

	public static int[] xorQueries(int[] arr, int[][] queries) {
		int[] prefix = new int[arr.length];
		prefix[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			prefix[i] = arr[i] ^ prefix[i - 1];
		}

		int[] res = new int[queries.length];

		for(int i = 0; i < queries.length; i++) {
			int left = queries[i][0];
			int right = queries[i][1];
			if (left == right) {
				res[i] = arr[left];
			} else if (left == 0) {
				res[i] =  prefix[right];
			} else {
				res[i] = prefix[right] ^ prefix[left - 1];
			}
		}

		return res;

	}
}
