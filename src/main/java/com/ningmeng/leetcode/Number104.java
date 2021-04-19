package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 21:41:36
 * @Version 1.0
 */
public class Number104 {

	/**
	 * 二叉树的最大深度
	 */

	int max = 0;
	public int maxDepth(TreeNode root) {
		dfs(root,1);
		return max;
	}


	public void dfs(TreeNode node, int n) {
		if (node == null) {
			max = Math.max(max, n-1);
			return ;
		}

		dfs(node.left, n + 1);
		dfs(node.right, n + 1);
	}
}
