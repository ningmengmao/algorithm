package com.ningmeng.leetcode;

public class Number3 {

    public static void main(String[] args) {
        Solution solution = new Solution();

        int length = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(length);

        System.out.println(solution.lengthOfLongestSubstring("bbbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring(""));
    }


    private static class Solution {
        public int lengthOfLongestSubstring(String s) {

            char[] array = s.toCharArray();
            Integer[] radix = new Integer[128];
            int max = 0;
            int count = 0;
            for (int i = 0; i < array.length; i++) {
                int ii = getIndex(array[i]);
                if (radix[ii] == null) {
                    radix[ii] = i;
                    count ++;
                    if (i == array.length - 1 && count > max) {
                        max = count;
                    }
                } else {
                    // 把i之前的都去掉
                    if (count > max) {
                        max = count;
                    }
                    count -= clearRadix(radix, radix[ii]);
                    radix[ii] = i;
                }
            }
            return max;
        }

        public int getIndex(char c) {
            return c;
        }

        private int clearRadix(Integer[] arr, int flag) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != null && arr[i] < flag) {
                    arr[i] = null;
                    count ++;
                }
            }
            return count;
        }
    }
}


