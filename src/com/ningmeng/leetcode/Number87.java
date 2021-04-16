package com.ningmeng.leetcode;

import java.time.Instant;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ningmengmao
 * @Date 2021-04-16 13:38:00
 * @Version 1.0
 */
public class Number87 {

	public static void main(String[] args) {

		Number87 number87 = new Number87();
		Instant now = Instant.now();

		System.out.println(number87.isScramble("greatasd", "rgeatdas"));
		Instant now1 = Instant.now();
		System.out.println(now1.toEpochMilli() - now.toEpochMilli());
	}

	/**
	 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
	 * 如果字符串的长度为 1 ，算法停止
	 * 如果字符串的长度 > 1 ，执行下述步骤：
	 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
	 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
	 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
	 * 给你两个 长度相等 的字符串 s1和s2，判断s2是否是s1的扰乱字符串。如果是，返回 true ；否则，返回 false 。
	 *
	 * 来源：力扣（LeetCode）
	 * 链接：https://leetcode-cn.com/problems/scramble-string
	 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
	 */


	public boolean isScramble(String s1, String s2) {

		int len = s1.length();
		String[][][] arr = new String[len][len][(int)Math.pow(2, len - 1)];


		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = i; j < s1.length(); j++) {
				String[] temp = arr[i][j];
				if (i == j) {
					temp[0] = String.valueOf(s1.charAt(i));
				} else {
					for (int k = i; k < j; k++) {
						System.out.println(k+1 + ", " + j);
						add(arr[i][k], arr[k+1][j], temp) ;
					}
				}
			}

			for (int j = 0; j < i; j++) {
				arr[i][j] = null;
			}
		}
		boolean result = false;
		for (String s : arr[0][len - 1]) {
			if (s2.equals(s)) {
				result = true;
				break;
			}
		}
		return result;
	}

	private void add(String[] s1, String[] s2, String[] res) {
		int index = 0;
		for (String i : s1) {
			if(i==null) {
				break;
			}
			for (String j : s2) {
				if (j != null) {
					res[index++] = i + j;
					res[index++] = j + i;
				} else {
					break;
				}
			}
		}
	}

	public List<String> add(List<String> s1, List<String> s2) {
		return s1.stream().flatMap(e -> {
			LinkedList<String> temp = new LinkedList<>();
			for (String s : s2) {
				temp.add(s + e);
				temp.add(e + s);
			}
			return temp.stream();
		}).collect(Collectors.toCollection(LinkedList::new));
	}


	class Arr{
		HashMap<String, LinkedList<String>> map;
		int len;
		public Arr (int len) {
			this.len = len;
			this.map = new HashMap<>(len * len);
		}
		public boolean set(int n1, int n2, String value) {
			LinkedList<String> strings = get(n1, n2);
			if (strings == null) {
				strings = new LinkedList<>();
				map.put(n1 + "," + n2, strings);
			}

			return strings.add(value);
		}

		public boolean set(int n1, int n2, List<String> list) {
			LinkedList<String> strings = get(n1, n2);
			if (strings == null) {
				strings = new LinkedList<>();
				map.put(n1 + "," + n2, strings);
			}

			return strings.addAll(list);
		}

		public LinkedList<String> get(int n1, int n2) {
			return map.get(n1 + "," + n2);
		}
	}
	
	
}


/*
public boolean isScramble(String s1, String s2) {
		Arr arr = new Arr(s1.length());

		for (int i = 0; i < s1.length(); i++) {
			arr.set(i, i, String.valueOf(s1.charAt(i)));
		}

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = i + 1; j < s1.length(); j++) {
				for (int k = i; k < j; k++) {
					arr.set(i, j , add(arr.get(i,k), arr.get(k + 1, j)));
				}
			}
		}

		LinkedList<String> list = arr.get(0, s1.length() - 1);

		boolean result = false;
		for (String s : list) {
			if (s.equals(s2)) {
				result = true;
				break;
			}
		}

		return result;
	}

	public List<String> add(List<String> s1, List<String> s2) {
		return s1.stream().flatMap(e -> {
			LinkedList<String> temp = new LinkedList<>();
			for (String s : s2) {
				temp.add(s + e);
				temp.add(e + s);
			}
			return temp.stream();
		}).collect(Collectors.toCollection(LinkedList::new));
	}


	class Arr{
		HashMap<String, LinkedList<String>> map;
		int len;
		public Arr (int len) {
			this.len = len;
			this.map = new HashMap<>(len * len);
		}
		public boolean set(int n1, int n2, String value) {
			LinkedList<String> strings = get(n1, n2);
			if (strings == null) {
				strings = new LinkedList<>();
				map.put(n1 + "," + n2, strings);
			}

			return strings.add(value);
		}

		public boolean set(int n1, int n2, List<String> list) {
			LinkedList<String> strings = get(n1, n2);
			if (strings == null) {
				strings = new LinkedList<>();
				map.put(n1 + "," + n2, strings);
			}

			return strings.addAll(list);
		}

		public LinkedList<String> get(int n1, int n2) {
			return map.get(n1 + "," + n2);
		}
	}
 */
