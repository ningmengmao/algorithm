package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-04 15:04:51
 * @Version 1.0
 */
public class Number1351 {

	public static void main(String[] args) {
		Number1351 main = new Number1351();

		int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
		System.out.println(main.countNegatives(grid));
	}

	public int countNegatives(int[][] grid) {
		int res = 0;
		for(int[] arr : grid) {
			res += (grid.length - sum(arr, 0, arr.length));
		}
		return res;
	}

	private int sum(int[] arr, int start, int end) {
		if (start == end) {
			return start;
		}

		int mid = (end + start) / 2;

		if (arr[mid] >= 0) {
			return sum(arr, mid + 1, end);
		} else {
			return sum(arr, start, mid);
		}
	}
}
