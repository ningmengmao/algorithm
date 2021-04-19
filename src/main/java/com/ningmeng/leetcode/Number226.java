package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 21:36:26
 * @Version 1.0
 */
public class Number226 {

	/**
	 * 反转二叉树
	 * @param root
	 * @return
	 */
	public TreeNode invertTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertTree(root.left);
		invertTree(root.right);
		return root;
	}
}
