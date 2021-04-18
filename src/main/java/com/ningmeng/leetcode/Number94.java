package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 18:19:03
 * @Version 1.0
 */
public class Number94 {
	/**
	 * 给定一个二叉树的根节点 root ，返回它的 中序 遍历。
	 */

	List<Integer> list = new LinkedList<>();
	public List<Integer> inorderTraversal(TreeNode root) {

		dfs(root);
		return list;
	}


	public void dfs(TreeNode node) {
		if (node == null) {
			return;
		}

		dfs(node.left);
		list.add(node.val);
		dfs(node.right);
	}
}
