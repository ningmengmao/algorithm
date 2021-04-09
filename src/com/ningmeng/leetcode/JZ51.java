package com.ningmeng.leetcode;


public class JZ51 {

    public static void main(String[] args) {
        int[] arr = {7,7,7,7,7,7};
        int result = reversePairs(arr);
        System.out.println(result);

    }


    private static int index = 0;
    public static int reversePairs(int[] nums) {

        if (nums.length < 2) {
            return 0;
        }
        Node node = new Node(nums[nums.length - 1]);
        int count = 0;
        int nodeLength = 1;
        for (int i = nums.length - 2; i >=0 ; i--) {
            node = insertIntoNode(node, nums[i]);
            nodeLength += 1;
            count = count + nodeLength - index - 1;
        }


        return count;
    }


    // 相等的时候插入到后面
    private static Node insertIntoNode(Node node, int number) {
        index = 0;
        Node head = node;
        Node before = null;
        while(node != null) {
//            if (node.data == number) {
//                Node temp = node.next;
//                node.next = new Node(number);
//                node.next.next = temp;
//                index += 1;
//                break;
//            } else
                if (node.data < number) {
                Node temp = new Node(number);
                temp.next = node;
                if (before!=null) {
                    before.next = temp;
                    break;
                } else {
                    return temp;
                }
            }
            index += 1;
            before = node;
            if (node.next == null) {
                node.next = new Node(number);
                break;
            }
            node = node.next;
        }
        return head;
    }

    static class Node {
        int data;
        Node next;
        public Node(int data) { this.data = data; }
        public Node(){}

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
}
