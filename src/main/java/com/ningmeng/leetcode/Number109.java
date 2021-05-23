package com.ningmeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 18:27:32
 * @Version 1.0
 */
public class Number109 {

	public static void main(String[] args) {
		var main = new Number109();
		var root = generate(new int[]{-10, -3, 0, 5, 9});
		var node = main.sortedListToBST(root);
	}


	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new ArrayList<>();
		while(head != null) {
			list.add(head.val);
			head = head.next;
		}

		TreeNode root = new TreeNode(list.get(list.size() / 2));
		root.left = add(list, 0, list.size() / 2);
		root.right = add(list, list.size() / 2 + 1, list.size());
		return root;
	}

	private TreeNode add(List<Integer> list, int start, int end) {

		if (start == end) {
			return null;
		}
		int mid = start + (end - start) / 2;
		TreeNode node = new TreeNode(list.get(mid));
		node.left = add(list, start, mid);
		node.right = add(list, mid + 1, end);
		return node;
	}


	public static ListNode generate(int[] arr) {
		ListNode root = new ListNode();
		ListNode node = root;
		for(int i : arr) {
			node.next = new ListNode(i);
			node = node.next;
		}
		return root.next;
	}
}
