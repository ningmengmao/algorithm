package com.ningmeng.base.graph;

import java.util.Arrays;
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

	public void prim() {

		boolean[] used = new boolean[matrix.length];
		// 找到图里最短的边
		int[][] edge = new int[matrix.length - 1][2];

		int a = -1;
		int b = -1;
		used[0] = true;
		for (int k = 0; k < matrix.length - 1; k++) {  // n
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < matrix.length; i++) {  // n * n
				if (used[i]) {
					for (int j = 0; j < matrix.length; j++) {
						if (matrix[i][j] > 0 && matrix[i][j] < min && !used[j]) {
							min = matrix[i][j];
							a = i;
							b = j;
						}
					}
				}
			}
			edge[k][0] = a;
			edge[k][1] = b;
			used[a] = true;
			used[b] = true;
		}

		System.out.println();

	}
	
	
	public void prim2() {
		// 找到图里最短的边
		int[][] edge = new int[matrix.length - 1][2];

		// 其他未加入的点到已加入点的最短边距离
		int[] dist = new int[matrix.length];
		boolean[] used = new boolean[dist.length];

		// dist[i]对应的起点
		int[] start = new int[dist.length];

		used[0] = true;
		// 初始化距离
		System.arraycopy(matrix[0], 0, dist, 0, matrix.length);

		for(int i = 0; i < matrix.length - 1 ; i++) {
			int min = Integer.MAX_VALUE;
			int idx = 0;
			for (int j = 0; j < dist.length; j++) {
				if (dist[j] < min && !used[j] ) {
					min = dist[j];
					idx = j;
				}
			}
			used[idx] = true;
			for (int j = 0; j < dist.length; j++) {
				if(matrix[idx][j] < dist[j] && !used[j]) {
					dist[j] = matrix[idx][j];
					start[j] = idx;
				}
			}
			edge[i][0] = start[idx];
			edge[i][1] = idx;

		}

		for (int[] ints : edge) {
			System.out.print(Arrays.toString(ints) + "\t");
		}

	}

	public int[] dijkstra(int start, int target) {

		boolean[] used = new boolean[matrix.length];
		int[] way = new int[matrix.length];
		Arrays.fill(way, start);
		way[start] = -1;

		used[start] = true;
		int[] dist = new int[matrix.length];
		System.arraycopy(matrix[start], 0, dist, 0, matrix.length);
		while(true) {
			int index = 0;
			index = getMinWeight(dist, used, index, start);

			if (index == -1) {
				break;
			}

			used[index] = true;

			int[] arr = matrix[index];
			for (int i = 0; i < matrix.length; i++) {
				if(arr[i] != Integer.MAX_VALUE && arr[i] + dist[index] < dist[i] && !used[i]) {
					dist[i] = arr[i] + dist[index];
					way[i] = index;
				}
			}
		}

		return way;
	}

	private int getMinWeight(int[] dist, boolean[] used, int index, int start) {

		int weight = Integer.MAX_VALUE;
		int result = -1;

		// 第一次循环
		if (index == start) {
			for (int i = 0; i < dist.length; i++) {
				if (!used[i] && dist[i] > 0 && dist[i] < weight) {
					weight = dist[i];
					result = i;
				}
			}
		}
		// 其他的
		else {
			for (int i = 0; i < dist.length; i++) {
				int target = matrix[index][i];
				if (!used[i] && target > 0 && target < weight ) {
					weight = target;
					result = i;
				}
			}
		}

		return result;
	}


	public static void main(String[] args) {
//		run();
		run2();

	}


	private static void run2() {
		Graph2 graph = new Graph2();
		graph.initMatrix(13);

		graph.add(0,1,3);
		graph.add(0,2,2);
		graph.add(0,3,2);

		graph.add(1,4,4);
		graph.add(1,3,1);

		graph.add(2,4,5);

		graph.add(3,5,1);
		graph.add(3,4,3);

		graph.add(4,6,3);
		graph.add(5,6,4);

		graph.add(6,7,6);
		graph.add(6,8,8);
		graph.add(6,9,8);

		graph.add(7,10,7);
		graph.add(7,11,9);

		graph.add(8,11,10);

		graph.add(9,12,10);
		graph.add(11,12,10);

		int[] dijkstra = graph.dijkstra(0, 12);

		System.out.println(Arrays.toString(dijkstra));

	}

	private static void run() {
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


		Graph2 graph2 = new Graph2();

		graph2.initMatrix(6);
		graph2.add(0,1,6);
		graph2.add(0,4,8);
		graph2.add(0,5,4);
		graph2.add(1, 2, 6);
		graph2.add(1, 3, 1);
		graph2.add(1,4,5);
		graph2.add(1,5,5);
		graph2.add(2,3,2);
		graph2.add(3,4,4);
		graph2.add(2,5,3);
		graph2.prim2();

		int[] dijkstra = graph2.dijkstra(0, 3);

		System.out.println("------------");

		System.out.println(Arrays.toString(dijkstra));
	}
}
