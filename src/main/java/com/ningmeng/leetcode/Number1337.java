package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @Author ningmengmao
 * @Date 2021-05-09 21:05:25
 * @Version 1.0
 */
public class Number1337 {

	public static void main(String[] args) {
		Number1337 main = new Number1337();
		var arr = new int[][]{
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 0},
				{1, 0, 0, 0, 0},
				{1, 1, 0, 0, 0},
				{1, 1, 1, 1, 1}
		};
		var res = main.kWeakestRows(arr, 3);

		System.out.println(Arrays.toString(res));
	}

	public int[] kWeakestRows(int[][] mat, int k) {
		PriorityQueue<int[]> queue = new PriorityQueue<>((arr1, arr2) -> {
			int res = Integer.compare(arr1[1], arr2[1]);
			if (res == 0) {
				return Integer.compare(arr1[0], arr2[0]);
			}
			return res;
		});
		int[] res = new int[k];

		for (int i = 0; i < mat.length; i++) {
			int r = get(mat[i]);
			queue.offer(new int[]{i, r});
		}
		int i = 0;
		while (i < res.length) {
			int[] r = queue.poll();
			res[i] = r[0];
			i++;
		}


		return res;

	}


	private int get(int[] arr) {
		int l = 0;
		int r = arr.length - 1;

		while (l < r) {
			int mid = (r - l) / 2 + l;

			if (arr[mid] >= 1) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}

		if (r < 0) {
			return 0;
		}

		if (arr[r] == 1) {
			return r + 1;
		} else {
			return r;
		}



	}
}
