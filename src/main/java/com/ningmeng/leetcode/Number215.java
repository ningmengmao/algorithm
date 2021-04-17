package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 19:39:58
 * @Version 1.0
 */
public class Number215 {

	public static void main(String[] args) {
		int[] arr = {3,2,3,1,2,4,5,5,6};
		Number215 number215 = new Number215();

		System.out.println(number215.findKthLargest(arr, 4));
	}

	public  int findKthLargest(int[] nums, int k) {
		int[] heap = new int[k];

		for (int i = 0; i < k; i++) {
			heap[i] = nums[i];
		}
		for(int i = (k -2 ) / 2; i>=0; i--) {
			heapify(heap, i);
		}

		for(int i=k; i<nums.length;i++) {
			if (nums[i] > heap[0]) {
				heap[0] = nums[i];
				heapify(heap, 0);
			}
		}

		return heap[0];
	}

	public void heapify(int[] heap, int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < heap.length && heap[lc] < heap[parent]) {
			swap(heap, lc, parent);
			heapify(heap, lc);
		}

		if (rc < heap.length && heap[rc] < heap[parent]) {
			swap(heap, rc, parent);
			heapify(heap, rc);
		}
	}

	public void swap(int[] heap, int n, int m) {
		int t = heap[n];
		heap[n] = heap[m];
		heap[m] = t;
	}
}
