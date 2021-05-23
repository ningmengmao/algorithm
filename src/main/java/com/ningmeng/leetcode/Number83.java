package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 13:50:29
 * @Version 1.0
 */
public class Number83 {

	public ListNode deleteDuplicates(ListNode head) {

		ListNode res = head;

		while(head != null) {
			while (head.next != null) {
				if (head.val == head.next.val) {
					head.next = head.next.next;
				}else {
					break;
				}
			}
			head = head.next;
		}

		return res;

	}
}
