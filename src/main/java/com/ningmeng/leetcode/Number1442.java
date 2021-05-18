package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-05-18 09:37:09
 * @Version 1.0
 */
public class Number1442 {

	public int countTriplets(int[] arr) {

		int[] prefix = new int[arr.length + 1];
		prefix[0] = 0;
		for (int i = 1; i <= arr.length; i++) {
			prefix[i] = arr[i - 1] ^ prefix[i - 1];
		}
		int res = 0;
		// prefix[i]  = prefix[k + 1]
		for (int i = 0; i < prefix.length; i++) {
			for (int k = i + 1; k < prefix.length - 1; k++) {
				if(prefix[i] == prefix[k + 1]) {
					res += (k - i);
				}
			}
		}

		return res;
	}
}
