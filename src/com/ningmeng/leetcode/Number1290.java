package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-06 21:12:49
 * @Version 1.0
 */
public class Number1290 {

	public static void main(String[] args) {
		Number1290 number1290 = new Number1290();


		int[] arr = {1,0,0,1,0,0,1,1,1,0,0,0,0,0,0};
		ListNode listNode = number1290.build(arr);

		System.out.println(number1290.getDecimalValue(listNode));
	}


	public ListNode build(int[] arr) {
		ListNode listNode = new ListNode(arr[0]);

		ListNode temp = listNode;
		for (int i = 1 ; i < arr.length; i++) {
			temp.next = new ListNode(arr[i]);
			temp = temp.next;
		}

		return listNode;
	}

	static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

	public int getDecimalValue(ListNode head) {
		return f(head, 0);
	}

	int deep = 0;

	public int f(ListNode head, int n) {
		deep++;
		if (head.next == null) {
			return head.val;
		}
		int f = f(head.next, n + 1);
		int i = (int) Math.pow(2, deep  - n - 1) * head.val;
		return i + f;
	}
}
