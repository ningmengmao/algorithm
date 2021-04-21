package com.ningmeng.nowcoder;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 14:34:25
 * @Version 1.0
 */

public class NC78 {

	public static void main(String[] args) {
		ListNode listNode = new ListNode(0);
		ListNode temp = listNode;
		for (int i = 1; i < 6; i++) {
			temp.next = new ListNode(i);
			temp = temp.next;
		}

		ListNode res = ReverseList2(listNode);

		while (res != null) {
			System.out.print(res.val);
			res = res.next;
		}
	}


	public ListNode ReverseList(ListNode head) {

		if (head == null) {
			return null;
		}

		ListNode temp = new ListNode(head.val);
		head = head.next;
		while (head != null) {
			ListNode t = new ListNode(head.val);
			t.next =temp;
			temp = t;
			head = head.next;
		}

		return temp;
	}

	public static ListNode ReverseList2(ListNode node) {

		if (node.next == null) {
			return node;
		}

		ListNode n = ReverseList2(node.next);
		node.next.next = node;
		node.next = null;
		return n;
	}




}
