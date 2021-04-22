package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 14:55:12
 * @Version 1.0
 */
public class Number700 {

	public TreeNode searchBST(TreeNode root, int val) {
		if (root == null) {
			return null;
		}
		TreeNode res;
		if (root.val == val) {
			return root;
		} else if (root.val < val) {
			res = searchBST(root.right, val);
		} else {
			res = searchBST(root.left, val);
		}

		return res;


	}
}
