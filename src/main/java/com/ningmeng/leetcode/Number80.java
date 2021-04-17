package com.ningmeng.leetcode;

import java.util.Arrays;

public class Number80 {


    public static void main(String[] args) {
        int[] arr = {1,12};

        Number80 number80 = new Number80();
        System.out.println(number80.removeDuplicates2(arr));
        System.out.println(Arrays.toString(arr));


    }

    public int removeDuplicates2(int[] nums) {
        StringBuilder sb = new StringBuilder();
        int current = nums[0];
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == current) {
                count ++;
            } else {
                if (count > 1) {
                    sb.append(current + ",").append(current+",");
                } else {
                    sb.append(current+",");
                }
                count = 1;
                current = nums[i];
            }
        }
        if (count > 1) {
            sb.append(current+",").append(current);
        } else {
            sb.append(current);
        }

        int index = 0;
        for(String s : sb.toString().split(",")) {
            nums[index++] = Integer.parseInt(s);
        }
        return sb.toString().split(",").length;

    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }


        int s = 0;
        int len = 0;
        int current = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == Integer.MIN_VALUE) {
                break;
            }
            if (current == nums[i]) {
                s++;
            } else {
                if (s > 2) {
                    move(nums, i - s + 2, i);
                    i = i - s + 2;
                }
                len += 2;
                s = 1;
                current = nums[i];
            }
        }
        if (s > 1) {
            len += 2;
        } else {
            len += 1;
        }
        return len;

    }

    public void move(int[] arr, int start, int last) {
        int index = start;
        int count = 0;
        for (int i = last; i < arr.length; i++) {
            arr[index++] = arr[i];
        }
        for (int i = index; i < arr.length; i++) {
            arr[i] = Integer.MIN_VALUE;
        }
    }
}
