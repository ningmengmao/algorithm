package com.ningmeng.base.sort;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-01 20:06:56
 * @Version 1.0
 */
public class Sort {

	public static void main(String[] args) {
		int[] arr = {3, 2, 5, 4, 1, 10, 8 ,9, 7, 6, 9, 6, 2, 0, 10};
//		treeSort(arr);
//		radixSort(arr, 10);
//		quickSort(arr);
		bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(int[] arr) {
		BubbleSort.sort(arr);
	}

	public static void quickSort(int[] arr) {
		QuickSort.sort(arr, 0, arr.length - 1);
	}

	public static void treeSort(int[] arr) {
		TreeSort.sort(arr);
	}

	public static void radixSort(int[] arr, int maxValue) {
		RadixSort.sort(arr, maxValue);
	}


	private static class TreeSort {
		public static void sort(int[] arr) {

			int lastParent = arr.length / 2;
			for (int i = lastParent; i >= 0; i--) {
				toHeap(arr, i, arr.length);
			}

			for (int i = arr.length - 1; i >=0 ; i--) {
				swap(arr, 0, i);
				toHeap(arr, 0, i);
			}

		}

		private static void toHeap(int[] arr, int index, int length) {
			int lc = index * 2 + 1;
			int rc = index * 2 + 2;
			if (lc < length && arr[lc] > arr[index]) {
				swap(arr, lc, index);
				toHeap(arr, lc, length);
			}
			if (rc < length && arr[rc] > arr[index]) {
				swap(arr, rc, index);
				toHeap(arr, rc, length);
			}
		}

		private static void swap(int[] arr, int first, int second) {
			int temp = arr[first];
			arr[first] = arr[second];
			arr[second] = temp;
		}
	}

	private static class RadixSort {
		private static class Node {
			int value;
			Node next;

			public Node(int value) {
				this.value = value;
			}

			public Node(int value, Node next) {
				this.value = value;
				this.next = next;
			}
			@Override
			public String toString() {
				return "value=" + value + ", next=" + next;
			}
		}
		
		public static void sort(int[] arr, int maxValue) {
			int length = String.valueOf(maxValue).length();
			for (int i = 0; i < length; i++) {
				Node[] radix = new Node[10];
				for (int j = 0; j < arr.length; j++) {
					int value = arr[j];
					int index = getNumber(value, i);
					if (radix[index] == null) {
						radix[index] = new Node(value);
					} else {
						Node temp = radix[index];
						while (temp.next != null) {
							temp = temp.next;
						}
						temp.next = new Node(value, null);
					}
				}

				int index = 0;
				for (int j = 0; j < 10; j++) {
					Node temp = radix[j];
					while (temp != null) {
						arr[index++] = temp.value;
						temp = temp.next;
					}
				}

			}
		}
		
		
		private static int getNumber(int value, int index) {
			String s = String.valueOf(value);
			if (index >= s.length()) {
				return 0;
			}
			return Integer.parseInt(String.valueOf(s.charAt(s.length() - 1 - index)));
		}
	}

	private static class QuickSort {
		public static void sort(int[] arr, int start, int end) {
			if (start >= end) {
				return;
			} else if (start - end == -1 && arr[start] > arr[end]) {
				swap(arr, start, end);
			}

			int flag = arr[start];
			int lp = start + 1;
			int rp = end;
			while (lp < rp) {
				if (arr[lp] < flag) {
					lp++;
				}
				if (arr[rp] >= flag) {
					rp--;
				}
				if (arr[lp] >= flag && arr[rp] < flag ) {
					swap(arr, lp, rp);
					lp ++;
					rp --;
				}
			}

			if (arr[lp] > flag) {
				swap(arr, start, lp - 1);
			} else {
				swap(arr, start, lp);
			}
			sort(arr, start, lp - 1);
			sort(arr, lp, end);
		}

		private static void swap(int[] arr, int first, int second) {
			int temp = arr[first];
			arr[first] = arr[second];
			arr[second] = temp;
		}
	}

	private static class BubbleSort {
		
		public static void sort(int[] arr) {
			for (int i = arr.length - 1 ; i >= 0; i--) {
				for (int j = 0; j < i; j++) {
					if (arr[j] > arr[j+1]) {
						swap(arr, j, j+1);
					}
				}
			}
		}

		private static void swap(int[] arr, int first, int second) {
			int temp = arr[first];
			arr[first] = arr[second];
			arr[second] = temp;
		}
	}
}
