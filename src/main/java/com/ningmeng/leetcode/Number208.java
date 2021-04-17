package com.ningmeng.leetcode;

import java.util.Arrays;

/**
 * @Author ningmengmao
 * @Date 2021-04-14 08:59:53
 * @Version 1.0
 */
public class Number208 {

	public static void main(String[] args) {

		Trie trie = new Trie();
		trie.insert("apple");
		System.out.println(trie.search("apple"));   // 返回 True
		System.out.println(trie.search("app"));     // 返回 False
		System.out.println(trie.startsWith("app")); // 返回 True
		trie.insert("app");
		System.out.println(trie.search("app"));     // 返回 True

		System.out.println("end");

	}

	static class Trie {

		Node rootNode;

		/** Initialize your data structure here. */
		public Trie() {
			rootNode = new Node();
		}

		/** Inserts a word into the trie. */
		public void insert(String word) {
			char[] chars = word.toCharArray();
			Node temp = rootNode;
			for (int i = 0, charsLength = chars.length; i < charsLength; i++) {
				char c = chars[i];
				if (temp.children == null) {
					temp.children = new Node[26];
				}

				if (temp.getChild(c) != null) {
					temp = temp.getChild(c);
				} else {
					Node node = new Node(c);
					temp.add(node);
					temp = node;
				}

				if (i == charsLength - 1) {
					temp.isEnd = true;
				}
			}

		}

		/** Returns if the word is in the trie. */
		public boolean search(String word) {
			char[] chars = word.toCharArray();
			Node temp = rootNode;
			for (int i = 0; i < chars.length; i++) {
				if (temp.children != null) {
					temp = temp.getChild(chars[i]);
					if (temp == null) {
						return false;
					} else if (i == chars.length - 1 && temp.isEnd) {
						return true;
					}
				}
			}
			return false;
		}

		/** Returns if there is any word in the trie that starts with the given prefix. */
		public boolean startsWith(String prefix) {
			char[] chars = prefix.toCharArray();
			Node temp = rootNode;
			for (char aChar : chars) {
				if(temp.children != null) {
					temp = temp.getChild(aChar);
					if (temp == null) {
						return false;
					}
				} else {
					return false;
				}
			}
			return true;
		}


		static class Node {
			char val;
			Node[] children;
			boolean isEnd;

			public Node(){}
			public Node(char val) {
				this.val = val;
			}

			public void add(Node child) {
				if(children == null) {
					children = new Node[26];
				}
				children[child.val - 'a'] = child;
			}

			public Node getChild(char val) {
				return children[val - 'a'];
			}

			@Override
			public String toString() {
				return "Node{" +
						"val=" + val +
						", children=" + Arrays.toString(children) +
						", isEnd=" + isEnd +
						'}';
			}
		}
	}
}
