package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-22 19:30:47
 * @Version 1.0
 */
public class MST1001 {

	public static void merge(int[] A, int m, int[] B, int n) {
		if (m == 0) {
			System.arraycopy(B, 0, A, 0, n);
			return;
		}

		m -= 1;
		n -= 1;
		int index = A.length - 1;
		while (m >= 0 && n >= 0) {
			if (A[m] > B[n]) {
				A[index] = A[m];
				m--;
			} else {
				A[index] = B[n];
				n--;
			}
			index--;
		}

		if (n >= 0) {
			System.arraycopy(B, 0, A, 0, n + 1);
		}

	}
}
