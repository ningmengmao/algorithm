package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-04 20:48:50
 * @Version 1.0
 */
public class Number876 {

	public ListNode middleNode(ListNode head) {
		ListNode f = head;
		ListNode s = head;
		while (f != null && f.next != null) {
			f = f.next.next;
			s = s.next;
		}
		return s;
	}
}
