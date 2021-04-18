package com.ningmeng.base.tree;


import com.ningmeng.leetcode.TreeNode;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 22:11:37
 * @Version 1.0
 */
public class Print {

	public static void main(String[] args) {
		System.out.print("      "); // 6
		System.out.printf("%4d", 0);
		System.out.println();

		System.out.print("     ____|____"); // 5, 4
		System.out.println();

		System.out.print("  ");    // 2
		System.out.printf("%4d", 1);
		System.out.print("    ");  // 4
		System.out.printf("%4d", 2);
		System.out.println();

		System.out.print("   __|__"); // 3, 2
		System.out.print("   __|__");
		System.out.println();

		System.out.printf("%4d", 333);
		System.out.printf("%4d", 433);
		System.out.printf("%4d", 533);
		System.out.printf("%4d", 633);
	}

	public static void print(TreeNode node) {



	}


	private static String bfs(TreeNode node) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		LinkedList<Integer> list = new LinkedList<>();
		queue.addLast(node);

		while(!queue.isEmpty()) {
			TreeNode first = queue.removeFirst();
			if (first != null) {
				list.add(first.val);
				queue.add(first.left);
				queue.add(first.right);
			} else {
				list.add(null);
				queue.addLast(null);
				queue.addLast(null);
			}
		}

		return "";
	}
}
