package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 18:20:35
 * @Version 1.0
 */
public class JZ55 {

	/**
	 * 输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
	 * 例如：
	 * 给定二叉树 [3,9,20,null,null,15,7]，
	 * 返回它的最大深度 3 。
	 * 链接：https://leetcode-cn.com/problems/er-cha-shu-de-shen-du-lcof
	 */


	int max = 0;
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		dfs(root, 1);
		return max;
	}


	public void dfs (TreeNode node, int n) {
		if (node.left == null && node.right == null) {
			max = Math.max(n, max);
			return;
		}

		boolean f = false;
		if (node.left != null) {
			f =true;
			dfs(node.left, ++n);
		}
		if (node.right != null) {
			if (f) {
				--n;
			}
			dfs(node.right, ++n);
		}
	}
}
