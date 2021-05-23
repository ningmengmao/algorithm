package com.ningmeng.base.other;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-05-23 15:08:32
 * @Version 1.0
 */
public class Trie {

	private char c;
	private Trie[] children;
	private boolean f;

	public static Trie newInstance() {
		return new Trie();
	}

	private Trie() {
	}

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

//	public boolean isWord(String str) {
//		Trie t = this;
//		for (int i = 0; i < str.length(); i++) {
//			t = t.children[str.charAt(i) - 'a'];
//			if (t == null) {
//				return false;
//			} else if (!t.f) {
//				return false;
//			}
//		}
//		return t.f;
//
//	}

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
