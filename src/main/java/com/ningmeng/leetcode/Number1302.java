package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 21:48:53
 * @Version 1.0
 */
public class Number1302 {


	/**
	 * 给你一棵二叉树的根节点 root ，请你返回 层数最深的叶子节点的和 。
	 */


	int max = 0;
	int sum = 0;
	public int deepestLeavesSum(TreeNode root) {
		dfs(root, 1);

		sum(root, 1);
		return sum;
	}

	public void dfs(TreeNode node, int n) {
		if (node == null) {
			max = Math.max(n-1, max);
			return;
		}

		dfs(node.left, n + 1);
		dfs(node.right, n + 1);
	}

	public void sum(TreeNode node, int n) {
		if (node == null) {
			return ;
		}
		if (n == max) {
			sum += node.val;
			return;
		}

		sum(node.left, n + 1);
		sum(node.right, n + 1);
	}
}
