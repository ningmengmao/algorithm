package com.ningmeng.leetcode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 18:19:54
 * @Version 1.0
 */
public class JZ27 {

	/**
	 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
	 */

	public TreeNode mirrorTree(TreeNode root) {
		if (root == null) {
			return null;
		}
		bfs(root);
		return root;
	}

	public void bfs(TreeNode node) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.addLast(node);

		while (!queue.isEmpty()) {
			node = queue.removeFirst();
			if (node != null) {
				queue.addLast(node.left);
				queue.addLast(node.right);
				TreeNode temp = node.left;
				node.left = node.right;
				node.right = temp;
			}
		}
	}
}
