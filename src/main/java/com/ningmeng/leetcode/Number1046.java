package com.ningmeng.leetcode;

import java.util.PriorityQueue;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 15:59:13
 * @Version 1.0
 */
public class Number1046 {

	public static void main(String[] args) {
		Number1046 number1046 = new Number1046();

		int[] arr = {2,7,4,1,8,1};


		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(3, Integer::compareTo);
		priorityQueue.remove();
		System.out.println(number1046.lastStoneWeight(arr));

	}

	public int lastStoneWeight(int[] stones) {

		if (stones.length == 1) {
			return stones[0];
		} else if (stones.length == 2) {
			return Math.abs(stones[1] - stones[0]);
		}

		int parent = (stones.length - 2) / 2;

		for(int i = parent; i>=0; i--) {
			toHeap(stones, i);
		}

		while(stones[1] != 0 || stones[2] != 0) {
			if (stones[1] >= stones[2]) {
				f(stones, 1);
				toHeap(stones, 1);
				toHeap(stones, 0);
			} else {
				f(stones, 2);
				toHeap(stones, 2);
				toHeap(stones,0);
			}
		}


		return stones[0];

	}

	public void f(int[] arr, int n) {
		int res = arr[0] - arr[n];
		arr[0] = res;
		arr[n] = 0;
	}


	public void toHeap(int[] heap, int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < heap.length && heap[lc] > heap[parent]) {
			swap(heap, lc, parent);
			toHeap(heap, lc);
		}
		if (rc < heap.length && heap[rc] > heap[parent]) {
			swap(heap, rc, parent);
			toHeap(heap, rc);
		}
	}

	public void swap(int[] heap, int n, int m) {
		int temp = heap[m];
		heap[m] = heap[n];
		heap[n] = temp;
	}
}
