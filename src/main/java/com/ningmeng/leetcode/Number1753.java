package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-28 15:23:14
 * @Version 1.0
 */
public class Number1753 {

	public static void main(String[] args) {
		System.out.println(maximumScore(2, 4, 6));
	}

	public static int maximumScore(int a, int b, int c) {
		int[] arr = {a,b,c};
		Arrays.sort(arr);
		int count = 0;
		while (true) {
			if (arr[1] > 0 ){
				arr[2] = arr[2] - 1;
				arr[1] = arr[1] - 1;
				Arrays.sort(arr);
				count ++;
			} else {
				break;
			}
		}
		return count;
	}
}
