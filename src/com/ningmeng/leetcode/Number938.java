package com.ningmeng.leetcode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 22:40:49
 * @Version 1.0
 */
public class Number938 {

	public int rangeSumBST(TreeNode root, int low, int high) {

		LinkedList<TreeNode> queue = new LinkedList<>();
		int sum = 0;
		queue.addLast(root);
		while (!queue.isEmpty()) {
			root = queue.removeFirst();
			if (root.val >= low && root.val <= high) {
				sum += root.val;
			}
			if (root.left != null && root.val > low) {
				queue.addLast(root.left);
			}
			if (root.right != null && root.val < high) {
				queue.addLast(root.right);
			}
		}
		return sum;
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

}
