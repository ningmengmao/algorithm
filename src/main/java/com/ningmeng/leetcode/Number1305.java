package com.ningmeng.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-04-18 22:47:03
 * @Version 1.0
 */
public class Number1305 {

	/**
	 * 给你 root1 和 root2 这两棵二叉搜索树。
	 *
	 * 请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
	 */

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> res = new LinkedList<>();
		LinkedList<Integer> s1 = new LinkedList<>();
		LinkedList<Integer> s2 = new LinkedList<>();

		dfs(root1, s1);
		dfs(root2, s2);
		while(!s1.isEmpty() && !s2.isEmpty()) {
			Integer i = s1.getFirst();
			Integer j = s2.getFirst();
			if (i <= j) {
				res.add(i);
				s1.removeFirst();
			} else {
				res.add(j);
				s2.removeFirst();
			}
		}

		if (!s1.isEmpty()) {
			res.addAll(s1);
		} else if (!s2.isEmpty()) {
			res.addAll(s2);
		}

		return res;
	}

	public void dfs(TreeNode node, LinkedList<Integer> list) {
		if (node == null) {
			return;
		}
		dfs(node.left, list);
		list.addLast(node.val);
		dfs(node.right, list);
	}
}
