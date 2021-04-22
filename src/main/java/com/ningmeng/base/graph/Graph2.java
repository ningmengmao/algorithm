package com.ningmeng.base.graph;

import java.util.LinkedList;

/**
 * @Author ningmengmao
 * @Date 2021-04-22 21:44:25
 * @Version 1.0
 */
public class Graph2 {

	int[][] matrix;

	public void initMatrix(int size) {
		matrix = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				matrix[i][j] = Integer.MAX_VALUE;
			}
		}
	}


	public void add(int from, int to, int weight) {
		matrix[from][to] = weight;
		matrix[to][from] = weight;
	}

	public int[] BFS(int from) {
//		LinkedList<Integer> res = new LinkedList<>();

		boolean[] used = new boolean[matrix.length];
		LinkedList<Integer> queue = new LinkedList<>();
		used[from] = true;
		queue.addLast(from);
		while (!queue.isEmpty()) {
			Integer first = queue.removeFirst();
			System.out.print( (char)('a' + first) + "\t");
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[first][i] < Integer.MAX_VALUE && !used[i]) {
					queue.addLast(i);
					used[i] = true;
				}
			}
		}

		return new int[0];
	}


	public int[] DFS(int from) {
//		LinkedList<Integer> res = new LinkedList<>();

		boolean[] used = new boolean[matrix.length];
		LinkedList<Integer> stack = new LinkedList<>();
		used[from] = true;
		stack.push(from);
		while (!stack.isEmpty()) {
			Integer first = stack.pop();
			System.out.print( (char)('a' + first) + "\t");
			for (int i = 0; i < matrix.length; i++) {
				if (matrix[first][i] < Integer.MAX_VALUE && !used[i]) {
					stack.push(i);
					used[i] = true;
				}
			}
		}

		return new int[0];
	}





	public static void main(String[] args) {
		Graph2 graph = new Graph2();

		graph.initMatrix(11);

		graph.add(0, 1, 1);
		graph.add(1, 2, 1);
		graph.add(1, 3, 1);
		graph.add(1, 4, 1);

		graph.add(4, 5, 1);
		graph.add(4, 6, 1);
		graph.add(4, 9, 1);

		graph.add(6, 7, 1);
		graph.add(6, 8, 1);
		graph.add(9, 10, 1);

		graph.BFS(0);

		System.out.println("------------");
		graph.DFS(0);
	}
}
