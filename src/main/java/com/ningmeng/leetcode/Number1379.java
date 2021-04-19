package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-19 21:59:20
 * @Version 1.0
 */
public class Number1379 {

	/**
	 * 给你两棵二叉树，原始树 original 和克隆树 cloned，以及一个位于原始树 original中的目标节点target。
	 *
	 * 其中，克隆树 cloned是原始树 original的一个 副本 。
	 *
	 * 请找出在树cloned中，与target相同的节点，并返回对该节点的引用（在 C/C++ 等有指针的语言中返回 节点指针，其他语言返回节点本身）。

	 * 注意：
	 *
	 * 你 不能 对两棵二叉树，以及 target节点进行更改。
	 * 只能 返回对克隆树cloned中已有的节点的引用。
	 *
	 * 进阶：如果树中允许出现值相同的节点，你将如何解答？
	 * 保存原树到target的路径, clone树延此路径到达克隆的target
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */
	
	TreeNode res = null;
	public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		dfs(original, cloned, target);
		return res;
	}


	public void dfs(TreeNode node1, TreeNode node2, TreeNode target) {
		if (node1 == null || node2 == null) {
			return;
		}
		if (node2.val == target.val) {
			res = node2;
			return;
		}

		dfs(node1.left, node2.left, target);
		dfs(node1.right, node2.right, target);
	}
}
