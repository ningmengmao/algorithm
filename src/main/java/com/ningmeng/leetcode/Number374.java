package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @Author ningmengmao
 * @Date 2021-04-28 15:34:49
 * @Version 1.0
 */
public class Number374 {

	public static void main(String[] args) {
		Number374 main = new Number374();

		int[] arr = {1,1,1,2,2,3,3,3,3,3,4,4,4,4,4,4,4,5,5,5,6,6,6,6};

		int[] res = main.topKFrequent(arr, 2);
		System.out.println(Arrays.toString(res));
	}


	HashMap<Integer, Integer> map = new HashMap<>();
	public int[] topKFrequent(int[] nums, int k) {

		for (int num : nums) {
			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		if (map.keySet().size() <= k) {
			return map.keySet().stream().mapToInt(e -> e).toArray();
		}
		int[] tree = new int[k];
		int idx = 0;
		for (Integer key : map.keySet()) {

			if (idx < k) {
				tree[idx++] = key;
			}  else {
				if (idx == k) {
					toHeap(tree);
					idx++;
				}
				if (map.get(key) > map.get(tree[0])) {
					tree[0] = key;
					heapify(tree, 0);
				}
			}
		}
		return tree;

	}


	public void toHeap(int[] tree) {
		int parent = (tree.length - 1 - 1) / 2;
		for (int i = parent; i >= 0; i--) {
			heapify(tree, i);
		}
	}

	public void heapify(int[] tree, int parent) {
		int lc = parent * 2 + 1;
		int rc = parent * 2 + 2;
		if (lc < tree.length && map.get(tree[lc]) < map.get(tree[parent])) {
			swap(tree, lc, parent);
			heapify(tree, lc);
		}
		if (rc < tree.length && map.get(tree[rc]) < map.get(tree[parent])) {
			swap(tree, rc, parent);
			heapify(tree, rc);
		}
	}

	public void swap(int[] tree, int n, int m) {
		int temp = tree[n];
		tree[n] = tree[m];
		tree[m] = temp;
	}
}
