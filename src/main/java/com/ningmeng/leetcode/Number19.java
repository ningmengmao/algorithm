package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-01 21:38:36
 * @Version 1.0
 */
public class Number19 {

	int index = 0;
	boolean f = false;
	public ListNode removeNthFromEnd(ListNode head, int n) {
		boolean res = f(head, n);
		if (res) {
			return head;
		} else {
			return head.next;
		}
	}

	public ListNode removeNthFromEnd2(ListNode head, int n) {
		ListNode listNode = new ListNode(0, head);
		ListNode f = head;
		ListNode s = listNode;
		for (int i = 0; i < n; i++) {
			f = f.next;
		}
		while (f != null) {
			f = f.next;
			s = s.next;
		}
		s.next = s.next.next;
		return listNode.next;
	}



	private boolean f(ListNode node, int n) {

		if (node == null) {
			index = 0;
			return false;
		}
		boolean next = f(node.next, n);
		index++;
		boolean res = false;
		if (index == n + 1) {
			node.next = node.next.next;
			res = true;
		}


		return res || next;
	}
}
