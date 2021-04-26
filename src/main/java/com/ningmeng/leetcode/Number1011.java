package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-26 09:06:52
 * @Version 1.0
 */
public class Number1011 {

	public static void main(String[] args) {
		Number1011 main = new Number1011();
		int[] weights = {1,2,3,4,5,6,7,8,9,10};
		System.out.println(main.shipWithinDays(weights, 1));
	}

	public int shipWithinDays(int[] weights, int D) {
		int max = 0;
		int sum = 0;
		for (int weight : weights) {
			max = Math.max(weight, max);
			sum += weight;
		}
		int begin = max;
		int end = sum;
		int res = end;
		while (begin < end) {
			int mid = (end + begin) / 2;
			if (f(weights, mid, D)) {
				res = mid;
				end = mid;
			} else {
				begin = mid + 1;
			}
		}
		return res;
	}

	public boolean f(int[] weights, int target, int D) {
		int sum = 0;
		int day = 1;
		for (int weight : weights) {
			if (sum + weight <= target) {
				sum += weight;
			} else {
				day++;
				sum = weight;
			}
		}
		return D >= day;
	}
}
