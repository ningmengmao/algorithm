package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 21:04:57
 * @Version 1.0
 */
public class Number973 {

	public int[][] kClosest(int[][] points, int k) {

		int[][] heap = new int[k][2];

		System.arraycopy(points, 0, heap, 0, k);

		for(int i = (k - 2) / 2; i>=0; i--) {
			heapify(heap, i);
		}

		for(int i = k; i < points.length; i++) {
			if ( gt(heap[0], points[i]) ){
				heap[0] = points[i];
				heapify(heap, 0);
			}
		}

		return heap;

	}


	public void heapify(int[][] heap, int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < heap.length && gt(heap[lc], heap[parent])) {
			swap(heap, lc, parent);
			heapify(heap, lc);
		}

		if (rc < heap.length && gt(heap[rc], heap[parent])) {
			swap(heap, rc, parent);
			heapify(heap, rc);
		}
	}


	public boolean gt(int[] a, int[] b) {
		return a[0] * a[0]  + a[1] * a[1] > b[0] * b[0] + b[1] * b[1];
	}




	public void swap(int[][] heap, int n, int m) {
		int[] temp = heap[n];
		heap[n] = heap[m];
		heap[m] = temp;
	}
}
