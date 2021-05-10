package com.ningmeng.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ningmengmao
 * @Date 2021-05-10 09:52:30
 * @Version 1.0
 */
public class Number872 {

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {

		if (root1 == null || root2 == null) {
			return false;
		}



		List<Integer> list1 = new ArrayList<>();
		dfs(root1, list1);
		List<Integer> list2 = new ArrayList<>();
		dfs(root2, list2);



		if (list1.size() != list2.size()) {
			return false;
		}

		for(int i = 0; i < list1.size(); i++) {
			if (!list1.get(i).equals(list2.get(i))) {
				return false;
			}
		}

		return true;

	}


	private void dfs(TreeNode node, List<Integer> list) {
		if (node == null) {
			return;
		}
		if (node.left == null && node.right == null) {
			list.add(node.val);
			return ;
		}

		dfs(node.left, list);
		dfs(node.right, list);
	}
}
