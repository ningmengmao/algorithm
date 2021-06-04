package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-06-04 20:19:31
 * @Version 1.0
 */
public class Number160 {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

		ListNode fn = headA;
		ListNode sn = headB;

		// 如果相交,则最终两个指针会在相交点汇合, 不相交则停在null
		while(fn != sn) {
			fn = fn != null ? fn.next : headB;
			sn = sn != null ? sn.next : headA;
		}
		return fn;
	}
}
