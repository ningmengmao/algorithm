package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 17:37:42
 * @Version 1.0
 */
public class Number203 {
	public ListNode removeElements(ListNode head, int val) {
		ListNode root = new ListNode();
		root.next = head;
		head = root;

		while(head != null) {
			while (head.next != null) {
				if (head.next.val == val) {
					head.next = head.next.next;
				} else {
					break;
				}
			}
			head = head.next;
		}
		return root.next;

	}
}
