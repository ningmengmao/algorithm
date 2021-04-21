package com.ningmeng.leetcode;

/**
 * @Author ningmengmao
 * @Date 2021-04-20 21:52:16
 * @Version 1.0
 */
public class Number28 {

	public static void main(String[] args) throws InterruptedException {
		String p = "aaaaaaab";
		String str1 = "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb";

		str1 = str1.repeat(100000 * 100);
		String finalStr = str1;
		Thread thread = new Thread(() -> {
			long l = System.currentTimeMillis();
			for (int i = 0; i < 1; i++) {
				int i1 = finalStr.indexOf(p);
			}
			long now = System.currentTimeMillis();
			System.out.println("indexOf " + (now - l));
		});

		Thread thread2 = new Thread(() -> {
			long l = System.currentTimeMillis();
			for (int i = 0; i < 1; i++) {
				strStr(finalStr, p);
			}
			long now = System.currentTimeMillis();
			System.out.println("strStr " + (now - l));
		});

		Thread thread3 = new Thread(() -> {
			long l = System.currentTimeMillis();
			for (int i = 0; i < 1; i++) {
				bm(finalStr , p);
			}
			long now = System.currentTimeMillis();
			System.out.println("bm " + (now - l));
		});

		thread.start();
		thread2.start();
		thread3.start();

		thread.join();
		thread2.join();
		thread3.join();



	}

	/**
	 * 实现strStr()函数。
	 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
	 *
	 * 说明：
	 *
	 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
	 *
	 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/implement-strstr
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */

	public static int strStr(String haystack, String needle) {
		if (needle.length() == 0) {
			return 0;
		}

		int res = -1;
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {

			int n = 0;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(i + j) == needle.charAt(j)) {
					n +=1;
				}
			}
			if (n == needle.length() ) {
				res = i;
				break;
			}

		}

		return res;
	}



	public static int bm(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return -1;
		}
		int[] arr = new int[128];

		for (int i = 0; i < 128; i++) {
			arr[i] = -1;
		}
		for (int i = 0; i < needle.length(); i++) {
			arr[needle.charAt(i)] = i;
		}

		int res = -1;

		int i = 0;
		int j = needle.length() - 1;

		while (i <= haystack.length() - needle.length()) {

			if (haystack.charAt(j + i) == needle.charAt(j)) {
				if (j == 0) {
					return i;
				}
				j--;
			} else {

				int move = j - arr[haystack.charAt(i + j)];
				if (move < 1) {
					move = 1;
				}
				i += move;
				j = needle.length() - 1;
			}
		}

		return res;

	}

	private static int getMove(char target, int q, String p) {

		assert q < p.length();
		for (int i = q - 1; i >= 0; i++) {
			if (p.charAt(i) == target) {
				return p.length() - 1 - i;
			}
		}


		return -1;
	}
}
