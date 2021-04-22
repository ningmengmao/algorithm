package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 14:58:38
 * @Version 1.0
 */
public class Number108 {

	public static void main(String[] args) {
		Number108 main = new Number108();
		int[] arr = {-1,0,1,2,3,4,5,6,7};
		System.out.println(main.sortedArrayToBST(arr));
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		return add(nums, 0, nums.length);
	}


	public TreeNode add(int[] nums, int start, int end) {
		if (start == end) {
			return null;
		}
		if (end - start == 1) {
			return new TreeNode(nums[start]);
		}
		if (end - start == 2) {
			TreeNode res = new TreeNode(nums[start]);
			res.right = new TreeNode(nums[start + 1]);
			return res;
		}
		if (end - start == 3) {
			TreeNode l = new TreeNode(nums[start]);
			TreeNode r = new TreeNode(nums[start + 2]);
			TreeNode res = new TreeNode(nums[start + 1]);
			res.left = l;
			res.right = r;
			return res;
		}

		int mid = (end - start) / 2 + start;
		TreeNode treeNode = new TreeNode(nums[mid]);
		treeNode.left = add(nums, start, mid);
		treeNode.right = add(nums,mid + 1, end);
		return treeNode;
	}
}
