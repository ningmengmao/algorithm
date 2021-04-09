package com.ningmeng.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-04 18:38:04
 * @Version 1.0
 */
public class Number1389 {


	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] arr = {0,1,2,3,4};
		int[] index = {0,1,2,2,1};
		int[] targetArray = solution.createTargetArray(arr, index);
		System.out.println(Arrays.toString(targetArray));
		ArrayList<Integer> integers = new ArrayList<>();
		integers.add(0,1);
	}


	static class Solution {
		public int[] createTargetArray(int[] nums, int[] index) {

			Node node = new Node();
			for (int i = 0; i < nums.length; i++) {
				if(index[ i] == 0) {
					if (node.data == null) {
						node.data = nums[i];
					} else {
						Node n = new Node(node.data);
						node.data = nums[i];
						n.next = node.next;
						node.next = n;
					}
				} else {
					insert(node, nums[i], index[i]);
				}
			}

			int[] result = new int[nums.length];
			for(int i=0; i<nums.length; i++) {
				result[i] = node.data;
				node = node.next;
			}
			return result;
		}

		// index > 0
		public void insert(Node node, int number, int index) {
			int count = 0;
			while (count < index) {
				if (node.next == null) {
					node.next = new Node();
				}
				count++;
				node = node.next;
			}
			if (node.data != null) {
				Node n = new Node(node.data);
				node.data = number;
				n.next = node.next;
				node.next = n;
			} else {
				node.data = number;
			}
		}



		static class Node {
			Integer data;
			Node next;

			public Node() {}

			public Node(Integer data) {
				this.data = data;
			}

			@Override
			public String toString() {
				return "Node{" +
						"data=" + data +
						", next=" + next +
						'}';
			}
		}
	}
}
