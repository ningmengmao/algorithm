package com.ningmeng.leetcode;

import java.util.Arrays;
import java.util.Optional;
import java.util.PriorityQueue;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 14:28:16
 * @Version 1.0
 */
public class Number720 {

	public static void main(String[] args) {
		var main = new Number720();
//		System.out.println(main.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
		System.out.println(main.longestWord(new String[]{"w","wo","wor","worl", "world"}));
	}

	public String longestWord(String[] words) {
		Trie tree = Trie.newInstance();
		Arrays.sort(words, String::compareTo);
		PriorityQueue<String> pq = new PriorityQueue<>((s1, s2) -> {
			int i = Integer.compare(s2.length(), s1.length());
			if (i == 0) {
				return s1.compareTo(s2);
			} else {
				return i;
			}
		});

		for(String str : words) {
			tree.add(str);
			if (tree.isWord(str)) {
				pq.offer(str);
			}
		}

		return Optional.ofNullable(pq.peek()).orElse("");

	}


}

class Trie {
	private char c;
	private Trie[] children;
	private boolean f;

	public static Trie newInstance() {
		return new Trie();
	}

	private Trie(){}

	private Trie(char c) {
		this.c = c;
	}

	private Trie(char c, boolean f) {
		this.c = c;
		this.f = f;
	}

	private Trie add(char a, boolean isEnd) {
		if (children == null) {
			children = new Trie[26];
		}
		if (children[a - 'a'] == null) {
			children[a - 'a'] = new Trie(a, isEnd);
			return children[a - 'a'];
		} else {
			children[a - 'a'].f = children[a - 'a'].f || isEnd;
			return children[a - 'a'];
		}
	}


	public void add(String str) {
		Trie t = this;
		for (int i = 0; i < str.length() - 1; i++) {
			t = t.add(str.charAt(i), false);
		}
		t.add(str.charAt(str.length() - 1), true);
	}

	public boolean isWord(String str) {
		Trie t = this;
		for(int i = 0; i < str.length(); i++) {
			t = t.children[str.charAt(i) - 'a'];
			if (t == null) {
				return false;
			} else if (!t.f) {
				return false;
			}
		}
		return t.f;

	}

	@Override
	public String toString() {
		return "Trie{" +
				"c=" + c +
				", children=" + Arrays.toString(children) +
				", f=" + f +
				'}';
	}

	public static void main(String[] args) {
		var root = newInstance();
		root.add("abcde");
		root.add("bcde");
		root.add("bc");
		root.add("a");
	}
}
