package com.ningmeng.base.search;

/**
 * @Author ningmengmao
 * @Date 2021-05-09 16:32:49
 * @Version 1.0
 */
public class BinarySearch {


	public static int search(int[] arr, int target) {

		int l = 0;
		int r = arr.length;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == target) {
				return mid;
			} else if (arr[mid] > target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return  -1;
	}



	/**
	 * 查询最接近target的数(比target大)的下标
	 * @param arr
	 * @param target
	 * @return
	 */
	public static int FirstOccurancesearch(int[] arr, int target) {

		int l = 0;
		int r = arr.length;

		while(l < r) {
			int mid = l + (r - l) / 2;

			// 不能把mid排除了
			if (arr[mid] >= target) {
				r = mid;
			} else {
				// 必须缩小范围
				l = mid + 1;
			}
		}

		return l;
	}
}
