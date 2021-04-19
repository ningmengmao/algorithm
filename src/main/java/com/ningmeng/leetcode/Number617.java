package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 21:38:11
 * @Version 1.0
 */
public class Number617 {


	/** dfs 合并两颗二叉树
	 * @param root1
	 * @param root2
	 * @return
	 */
	public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
		if (root1 == null) {
			return root2;
		}
		if (root2 == null) {
			return root1;
		}

		TreeNode root = new TreeNode(root1.val + root2.val);
		root.left = mergeTrees(root1.left, root2.left);
		root.right = mergeTrees(root1.right, root2.right);
		return root;

	}
}
