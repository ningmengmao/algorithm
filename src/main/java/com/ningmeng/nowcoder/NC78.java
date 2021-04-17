package com.ningmeng.nowcoder;

/**
 * @Author ningmengmao
 * @Date 2021-04-17 14:34:25
 * @Version 1.0
 */

public class NC78 {


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




}
