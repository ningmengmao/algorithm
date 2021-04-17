package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 18:11:26
 * @Version 1.0
 */
public class Number703 {

	public static void main(String[] args) {

		KthLargest k = new KthLargest(1, new int[]{});
		System.out.println(k.add(-3));
		System.out.println(k.add(-2));
		System.out.println(k.add(-4));
		System.out.println(k.add(0));
		System.out.println(k.add(4));
	}


}

class KthLargest{
	int[] heap;
	public KthLargest(int k, int[] nums) {
		heap = new int[k];
		if (k >= nums.length) {
			for(int i = 0; i < nums.length; i++) {
				heap[i] = nums[i];
			}
			for (int i = nums.length; i < k; i++) {
				heap[i] = Integer.MIN_VALUE;
			}

			for (int i = (k - 1) / 2; i >= 0 ; i--) {
				toHeap(i);
			}
		} else {
			for(int i = 0; i<k; i++) {
				heap[i] = nums[i];
			}
			for (int i = (k - 1) / 2; i >= 0 ; i--) {
				toHeap(i);
			}

			for (int i = k; i < nums.length; i++) {
				add(nums[i]);
			}
		}

	}

	private void toHeap(int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < heap.length && heap[lc] < heap[parent]) {
			swap(lc, parent);
			toHeap(lc);
		}

		if (rc < heap.length && heap[rc] < heap[parent]) {
			swap(rc, parent);
			toHeap(rc);
		}
	}

	private void swap(int n, int m) {
		int temp = heap[n];
		heap[n] = heap[m];
		heap[m] = temp;
	}

	public int add(int val) {
		if (val >= heap[0]) {
			heap[0] = val;
			toHeap(0);
		}
		return heap[0];
	}
}
