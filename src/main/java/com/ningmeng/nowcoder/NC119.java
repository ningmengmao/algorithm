package com.ningmeng.nowcoder;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 14:38:05
 * @Version 1.0
 */
public class NC119 {

	/**
	 * 最小的N个数
	 */

	public static void main(String[] args) {
		NC119 nc119 = new NC119();
		int[] arr = {4,5,1,6,2,7,3,8};

//		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Integer::compare);
//
//		for (int i : arr) {
//			priorityQueue.add(i);
//		}

//
		nc119.newSolution(arr, 4).forEach(e -> System.out.print(e + "  "));
	}


	public ArrayList<Integer> newSolution(int[] input , int k) {
		int[] heap = new int[k];
		if (input.length <= k) {
			return toList(input);
		}
		for (int i = 0; i < input.length; i++) {
			if(i < k ) {
				heap[i] = input[i];
			} else if (i == k) {
				toHeap(heap);
				if (heap[0] > input[i]) {
					heap[0] = input[i];
					heapify(heap, 0);
				}
			} else {
				if (heap[0] > input[i]) {
					heap[0] = input[i];
					heapify(heap, 0);
				}
			}
		}

		return toList(heap).stream().sorted(Integer::compare).collect(Collectors.toCollection(ArrayList::new));
	}


	public ArrayList<Integer> toList(int[] input) {
		ArrayList<Integer> result = new ArrayList<>(input.length);
		for (int i : input) {
			result.add(i);
		}
		return result;
	}

	public void toHeap(int[] heap) {
		int parent = (heap.length - 1 - 1) / 2;
		for (int i = parent; i >= 0 ; i--) {
			heapify(heap, i);
		}
	}

	public void heapify(int[] heap, int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;

		if (lc < heap.length && heap[lc] > heap[parent]) {
			swap(heap, lc, parent);
			heapify(heap, lc);
		}
		if(rc < heap.length && heap[rc] > heap[parent]) {
			swap(heap, rc, parent);
			heapify(heap, rc);
		}
	}



	public void swap(int[] heap, int n, int m){
		int temp = heap[n];
		heap[n] = heap[m];
		heap[m] = temp;
	}



	public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
		if (k > input.length){
			return new ArrayList<>();
		}

		ArrayList<Integer> list = new ArrayList<>();

		sort(input, 0, input.length - 1);
		for(int i=0; i<k; i++) {
			list.add(input[i]);
		}
		return list;
	}

	public  void sort(int[] input, int start, int end) {
		if(start >= end) {
			return ;
		}
		if(end - start == 1) {
			int temp = input[end];
			if (temp <= input[start]) {
				input[end] = input[start];
				input[start] = temp;
			}
			return;
		}

		int left = start + 1;
		int right = end;
		int flag = input[start];
		int temp = -1;
		while (left < right) {
			if (input[left] < flag ) {
				left ++;
			}
			if (input[right] >= flag ){
				right --;
			}
			if(input[left] >= flag && input[right] < flag) {
				temp = input[left];
				input[left] = input[right];
				input[right] = temp;
			}
		}
		temp = input[left];
		input[left] = input[start];
		input[start] = temp;
		sort(input, start, left);
		sort(input, left, end);
	}
}
