package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-13 09:40:38
 * @Version 1.0
 */
public class TreeNode {
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