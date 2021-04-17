package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-12 15:52:31
 * @Version 1.0
 */
public class Number1788 {

	public static void main(String[] args) {

		int[] arr = {1,4,2,5,3};

		System.out.println(dp(arr));
		System.out.println(sum(arr));

	}

	public static int sum(int[] arr) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j + i + 1  <= arr.length; j+=2) {
				sum+= f(arr, i, i + j + 1);
			}
		}

		return sum;

	}

	public static int f(int[] arr, int start, int end) {
		int sum = 0;
		for (int i = start; i < end; i++) {
			sum+=arr[i];
		}
		return sum;
	}


	public static int dp(int[] arr) {
		int[] dp = new int[arr.length];

		for (int i = 0; i < arr.length; i++) {
			dp[i] = 0;
			int count = (arr.length - i) % 2 == 0 ? (arr.length - i) / 2 : ((arr.length - i) + 1 ) / 2;
			for (int j = 0; j + i < arr.length && count > 0; j++) {
				if((j + 1) %2 == 0) {
					count--;
				}
				dp[i] += arr[i + j] * count;
			}
		}

		int sum = 0;
		for (int s : dp) {
			sum+=s;
		}

		return sum;
	}

}
