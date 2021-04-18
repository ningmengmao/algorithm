package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-13 09:40:38
 * @Version 1.0
 */
public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;

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

	@Override
	public String toString() {
		return "{" +
				"val=" + val +
				", left=" + left +
				", right=" + right +
				'}';
	}
}
